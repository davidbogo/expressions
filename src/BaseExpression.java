import java.util.ArrayList;
import java.util.List;

public abstract class BaseExpression implements Expression {
    // Returns a list of the variables in the expression.
    public List<String> combineVarLists(List<String> varList1, List<String> varList2) {
        List<String> combinedVarList = new ArrayList<String>();
        for (String str : varList1) {
            if (!combinedVarList.contains(str)) {
                combinedVarList.add(str);
            }
        }
        for (String str : varList2) {
            if (!combinedVarList.contains(str)) {
                combinedVarList.add(str);
            }
        }
        return combinedVarList;
    }
}
