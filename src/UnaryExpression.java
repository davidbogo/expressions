import java.util.List;

public abstract class UnaryExpression extends BaseExpression{
    protected Expression theExpression;

    public UnaryExpression(Expression expr) {
        theExpression = expr;
    }

    public List<String> getVariables() {
        return theExpression.getVariables();
    }

    protected String toString(String operator) {
        String operandString = theExpression.toString();
        Boolean alreadyHasBrackets = hasBrackets(operandString);
        String string = operator;
        if (!alreadyHasBrackets) {
            string += "(";
        }
        string += operandString;
        if (!alreadyHasBrackets) {
            string += ")";
        }
        return string;
    }
}
