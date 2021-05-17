import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Val implements Expression {
    private Boolean value;

    public Val(Boolean val) {
        value = val;
    }

    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return value;
    }

    // A convenience method. Like the `evaluate(assignment)` method above,
    // but uses an empty assignment.
    public Boolean evaluate() throws Exception {
        return value;
    }

    // Returns a list of the variables in the expression.
    public List<String> getVariables() {
        return new ArrayList<String>();
    }

    // Returns a nice string representation of the expression.
    public String toString() {
        return new String(value ? "T" : "F");
    }

    // Returns a new expression in which all occurrences of the variable
    // var are replaced with the provided expression (Does not modify the
    // current expression).
    public Expression assign(String var, Expression expression) {
        return new Val(value);
    }

    public Expression nandify() {
        return new Val(value);
    }

    public Expression norify() {
        return new Val(value);
    }

    public Expression simplify() {
        return new Val(value);
    }

    public int safeEvaluate() {
        return  value ? 1 : 0;
    }
}
