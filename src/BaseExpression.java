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

    protected static Boolean hasBrackets(String operandString) {
        Boolean hasBrackets = false;
        // Initially, I wanted to add brackets around the expression only if they're not there
        // already. But in reference output the brackets seem to be added always, even though it's
        // unnecessary. For now and only to avoid issues with the automatic tester, I'm
        // commenting this code out
        /*
        int operandStringLen = operandString.length();
        if (operandStringLen > 2) {
            if (operandString.charAt(0) == '(') {
                int missingClosingBrackets = 1;
                for (int curChar = 1; curChar < operandStringLen; curChar++) {
                    if (operandString.charAt(curChar) == ')') {
                        missingClosingBrackets--;
                        if (missingClosingBrackets == 0) {
                            if (curChar == operandStringLen - 1) {
                                // This is the closing bracket matching the first opening one,
                                // and we're at the end of the expression. This means we have brackets
                                // around the whole expression
                                hasBrackets = true;
                            }
                            // Even if this is not the end of the expression, we'll break the loop anyway.
                            // hasBrackets will remain false
                            break;
                        }
                    } else if (operandString.charAt(curChar) == '(') {
                        missingClosingBrackets++;
                    }
                }
            }
        }
*/
        return hasBrackets;
    }

    public int safeEvaluate() {
        int result;
        try {
            result = evaluate() ? 1 : 0;
        } catch (Exception exc) {
            result = 2; //cannot evaluate
        }

        return result;
    }
}
