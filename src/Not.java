import java.util.Map;

public class Not extends UnaryExpression {
    public Not(Expression expr) {
        super(expr);
    }

    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !theExpression.evaluate(assignment);
    }

    // A convenience method. Like the `evaluate(assignment)` method above,
    // but uses an empty assignment.
    public Boolean evaluate() throws Exception {
        return !theExpression.evaluate();
    }

    // Returns a nice string representation of the expression.
    public String toString() {
        return toString("~");
    }

    // Returns a new expression in which all occurrences of the variable
    // var are replaced with the provided expression (Does not modify the
    // current expression).
    public Expression assign(String var, Expression expression) {
        return new Not(theExpression.assign(var, expression));
    }

    // Returns the expression tree resulting from converting all the operations to the logical Nand operation.
    public Expression nandify() {
        return new Nand(theExpression.nandify(), theExpression.nandify());
    }

    // Returns the expression tree resulting from converting all the operations to the logical Nor operation.
    public Expression norify() {
        return new Nor(theExpression.norify(), theExpression.norify());
    }

    public Expression simplify() {
        return null;
    }
}
