import java.util.Map;

public class Xnor extends BinaryExpression {
    public Xnor(Expression expr1, Expression expr2) {
        super(expr1, expr2);
    }

    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !(expression1.evaluate(assignment) ^ expression2.evaluate(assignment));
        // It's OK to use bitwise XOR operator on boolean operands
    }

    // A convenience method. Like the `evaluate(assignment)` method above,
    // but uses an empty assignment.
    public Boolean evaluate() throws Exception {
        return !(expression1.evaluate() ^ expression2.evaluate());
        // It's OK to use bitwise XOR operator on boolean operands
    }

    // Returns a nice string representation of the expression.
    public String toString() {
        return toString("#");
    }

    // Returns a new expression in which all occurrences of the variable
    // var are replaced with the provided expression (Does not modify the
    // current expression).
    public Expression assign(String var, Expression expression) {
        return new Xnor(expression1.assign(var, expression), expression2.assign(var, expression));
    }
}