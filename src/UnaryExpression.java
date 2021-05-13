import java.util.List;

public abstract class UnaryExpression extends BaseExpression{
    protected Expression theExpression;

    public UnaryExpression(Expression expr) {
        theExpression = expr;
    }

    public List<String> getVariables() {
        return theExpression.getVariables();
    }

    public String toString(String operator) {
        String operandString = theExpression.toString();
        Boolean addBrackets = true;
        int operandStringLen = operandString.length();
        if (operandStringLen > 2) {
            if ((operandString.charAt(0) == '(') && (operandString.charAt(operandStringLen - 1) == ')'))  {
                addBrackets = false;
                // We already have brackets around the expression, no need to add more
            }
        }
        String string = operator;
        if (addBrackets) {
            string += "(";
        }
        string += operandString;
        if (addBrackets) {
            string += ")";
        }
        return string;
    }
}
