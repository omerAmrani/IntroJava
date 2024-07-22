package lessons.binaryTrees;

import lessons.binaryTrees.common.Tree;

public class L2 {

    /**
     * Checks if right son is bigger or equal to root.
     * Checks if left son is smaller than root.
     */
    public static boolean f(Tree t){
        if (t == null) return true;

        if (t.getLeftSon() == null && t.getRightSon() == null)
            return true;

        if (t.getRightSon() == null)
            return (t.getNumber() >  t.getLeftSon().getNumber())
                    &&  f(t.getLeftSon());

        if (t.getLeftSon() == null)
            return (t.getNumber() <=  t.getRightSon().getNumber())
                    &&  f(t.getRightSon());

        return  (t.getNumber() <= t.getRightSon().getNumber())
                && (t.getNumber() >  t.getLeftSon().getNumber())
                &&  f(t.getLeftSon())
                &&  f(t.getRightSon());
    }

    public boolean isSearchTree(Tree t, int a, int b) {
        if (t == null)  return true;

        return t.getNumber() > a &&
                t.getNumber() < b &&
                isSearchTree(t.getLeftSon(), a, t.getNumber()) &&
                isSearchTree(t.getRightSon(), t.getNumber(), b);
    }
}
