import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Var implements Expression {
    private String varName;

    public Var(String name) {
        varName = name;
    }

    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return assignment.get(varName);
    }

    // A convenience method. Like the `evaluate(assignment)` method above,
    // but uses an empty assignment.
    public Boolean evaluate() throws Exception {
        throw new Exception("Cannot evaluate !");
    }

    public List<String> getVariables() {
        List<String> listOfVariables = new ArrayList<String>();
        listOfVariables.add(new String(varName));
        return listOfVariables;
    }

    // Returns a nice string representation of the expression.
    public String toString() {
        return new String(varName);
    }

    // Returns a new expression in which all occurrences of the variable
    // var are replaced with the provided expression (Does not modify the
    // current expression).
    public Expression assign(String var, Expression expression) {
        if (var == varName) {
            return expression.assign("", null);
            // We just want to create a clone of the assigned expression,
            // with no recursive substitution, so we pass an empty string
            // and an empty expression for parameters
        }
        return new Var(varName);
    }

    public Expression nandify() {
        return new Var(varName);
    }

    public Expression norify() {
        return new Var(varName);
    }

    public Expression simplify() {
        return new Var(varName);
    }

    public int safeEvaluate() {
        return 2;  // Cannot evaluate
    }
}
