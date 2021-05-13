import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExpressionsTest {
    public static void main(String[] args) throws Exception {
        Expression e1 = new Not(
                            new Xor(
                                new And(
                                    new Val(true),
                                    new Or(
                                        new Var("x"),
                                        new Var("y")
                                    )
                                ),
                                new Var("x")
                            )
        );
        String s = e1.toString();
        System.out.println(s);

        Expression e2 = new Xor(new And(new Var("x"), new Var("y")), new Val(true));
        s = e2.toString();
        System.out.println(s);
        List<String> vars = e2.getVariables();
        for (String v : vars) {
            System.out.println(v);
        }

        Expression e3 = e1.assign("y", e2);
        s = e3.toString();
        System.out.println(s);

        e3 = e3.assign("x", new Val(false));
        s = e3.toString();
        System.out.println(s);
        Boolean value = e3.evaluate();
        // At this point the expression looks like this: ~((T & (F | ((F & y) ^ T))) ^ F)
        // Even though it contains an unassigned variable (y), the evaluation succeeds and
        // doesn't throw an exception. It's because the compiler is smart enough not to
        // call the evaluate() function for the "y" Var expression at all after the
        // evaluate() method returned FALSE for the first subexpression of the
        // And expression (F & y)
        System.out.println("e3 evaluation result is: " + value);

        Expression e4 = new Or(new Var("v1"), new Var("v2"));
        s = e4.toString();
        System.out.println(s);
/*      // If uncommented, this will throw an exception, which is by design since the values of v1 and v2
        // haven't been assigned
        value = e4.evaluate();
        System.out.println("e4 evaluation result is: " + value);
*/

        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", false);
        value = e2.evaluate(assignment);
        System.out.println("The result is: " + value);

        Expression e5 = new Not(new Var("v"));
        s = e5.toString();
        // This demonstrates that we can add brackets around unary expressions that don't already have them
        System.out.println(s);
    }
}
