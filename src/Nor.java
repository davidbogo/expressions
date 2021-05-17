import java.util.Map;

public class Nor extends BinaryExpression {
    public Nor(Expression expr1, Expression expr2) {
        super(expr1, expr2);
    }

    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !(expression1.evaluate(assignment) || expression2.evaluate(assignment));
    }

    // A convenience method. Like the `evaluate(assignment)` method above,
    // but uses an empty assignment.
    public Boolean evaluate() throws Exception {
        return !(expression1.evaluate() || expression2.evaluate());
    }

    // Returns a nice string representation of the expression.
    public String toString() {
        return toString("V");
    }

    // Returns a new expression in which all occurrences of the variable
    // var are replaced with the provided expression (Does not modify the
    // current expression).
    public Expression assign(String var, Expression expression) {
        return new Nor(expression1.assign(var, expression), expression2.assign(var, expression));
    }

    // Returns the expression tree resulting from converting all the operations to the logical Nand operation.
    public Expression nandify() {
        return new Nand((new Nand((new Nand(expression1.nandify(), expression1.nandify())),
                (new Nand(expression2.nandify(), expression2.nandify())))),
                (new Nand((new Nand(expression1.nandify(), expression1.nandify())),
                        (new Nand(expression2.nandify(), expression2).nandify()))));
    }

    // Returns the expression tree resulting from converting all the operations to the logical Nor operation.
    public Expression norify() {
        return this;
    }

    public Expression simplify() {
        Expression simplifiedExpression1 = expression1.simplify().assign("", null);  // create a clone;
        Expression simplifiedExpression2 = expression2.simplify().assign("", null);  // create a clone;
        int evaluation1 = simplifiedExpression1.safeEvaluate();
        int evaluation2 = simplifiedExpression2.safeEvaluate();
        if (evaluation1 == 0 && evaluation2 == 2) {
            return new Not(simplifiedExpression2);
        }
        if (evaluation1 == 2 && evaluation2 == 0) {
            return new Not(simplifiedExpression1);
        }
        if ((evaluation1 == 1 && evaluation2 == 2) || (evaluation1 == 2 && evaluation2 == 1)){
            return new Val(false);
        }
        if (evaluation1 == 1 && evaluation2 == 1) {
            return new Val(false);
        }
        if (evaluation1 == 0 && evaluation2 == 0) {
            return new Val(true);
        }
        if ((evaluation1 == 1 && evaluation2 == 0) || (evaluation1 == 0 && evaluation2 == 1)) {
            return new Val(false);
        }

        // None of the expressions could be evaluated, evaluation1 == 2 && evaluation2 == 2
        String string1 = simplifiedExpression1.toString();
        String string2 = simplifiedExpression2.toString();
        if (string1.equals(string2)) {
            return new Not(simplifiedExpression1);
        }
        return new Nor(simplifiedExpression1, simplifiedExpression2);
    }
}