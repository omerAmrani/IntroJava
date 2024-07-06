package binaryTrees;

import binaryTrees.common.Tree;

public class L1 {
    public static void printPreOrder(Tree root) {
        if (root != null) {
            System.out.println(root.getNumber() + " ");
            printPreOrder(root.getLeftSon());
            printPreOrder(root.getRightSon());
        }
    }

    public static void printInOrder(Tree root) {
        if (root != null) {
            printInOrder(root.getLeftSon());
            System.out.println(root.getNumber() + " ");
            printInOrder(root.getRightSon());
        }
    }

    public static void printPostOrder(Tree root) {
        if (root != null) {
            printPostOrder(root.getLeftSon());
            printPostOrder(root.getRightSon());
            System.out.println(root.getNumber() + " ");
        }
    }

    /**
     * Is root is bigger then the sons.
     * checks until the end of the tree.
     * @param t
     * @return true if root is bigger then the sons
     */
    public static boolean rootIsBigger(Tree t) {
        // if leaf
        if ((t.getLeftSon() == null) &&(t.getRightSon()== null))
            return true;

        // if only right, if root bigger then right
        if (t.getLeftSon() == null)
            return (t.getNumber() > t.getRightSon().getNumber())
                    && rootIsBigger(t.getRightSon());
        // if only left, if root bigger then left
        if (t.getRightSon() == null)
            return (t.getNumber() > t.getLeftSon().getNumber())
                    && rootIsBigger(t.getLeftSon());

        return  (t.getNumber() > t.getLeftSon().getNumber())
                && (t.getNumber() > t.getRightSon().getNumber())
                && rootIsBigger(t.getLeftSon())
                && rootIsBigger(t.getRightSon());
    }

    /**
     * @param n
     * @return max leaf in tree
     */
    public static int maxLeaf(Tree n) {
        if (n == null) return 0;

        if ((n.getLeftSon() == null) && (n.getRightSon() == null))
            return n.getNumber();

        if (n.getRightSon() == null)
            return (maxLeaf(n.getLeftSon()));

        if (n.getLeftSon() == null)
            return (maxLeaf(n.getRightSon()));

        int a = maxLeaf(n.getLeftSon());
        int b = maxLeaf(n.getRightSon());

        return Math.max(a, b);
    }
}
