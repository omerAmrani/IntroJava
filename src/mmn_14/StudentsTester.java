package mmn_14;


public class StudentsTester
{
    public static void main()
    {
        IntListTwo l1 = new IntListTwo();
        l1._head = null;
        l1.addToEnd(10);
        l1.addToEnd(10);
        int tempI = l1.win();
        boolean tempB = l1.betterWhat(1);

        IntListTwo l2 = new IntListTwo();
        l2._head = null;
        l2.addToEnd(10);

        tempI = l1.longestCommonSublist(l2);
        tempI = l1.maxEqualValue();

        System.out.println("\n============================\n" +
        "If you see this message,\n" +
        "it means your software worked fine with this tester,\n" +
        "which only means you wrote all the expected methods\n" +
        "with the right interface.\n" +
        "It DOES NOT MEAN your software does exactly what it is\n" +
        "expected to do.\n" +
        "To check that, you will have to write your own tester\n" +
        "which must include all sorts of scenarios.\n" +
        "The bugs your tester doesn't find - will be found\n" +
        "by your instructor's tester, and will cost you\n" +
        "points in your grade.");
    
    }
}
