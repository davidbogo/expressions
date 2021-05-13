import java.util.List;

public abstract class BinaryExpression extends BaseExpression {
    protected Expression expression1;
    protected Expression expression2;

    public BinaryExpression(Expression expr1, Expression expr2) {
        expression1 = expr1;
        expression2 = expr2;
    }

    public List<String> getVariables() {
        return combineVarLists(expression1.getVariables(), expression2.getVariables());
    }

    public String toString(String operator) {
        String string = new String("(");
        string += expression1.toString();
        string += " ";
        string += operator;
        string += " ";
        string += expression2.toString();
        string += ")";
        return string;
    }
}
