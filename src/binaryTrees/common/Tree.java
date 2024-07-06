package binaryTrees.common;

public class Tree {
    private int number;
    private Tree left;
    private Tree right;

    public Tree(int number) {
        this.number = number;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public int getNumber() { return number; }
    public Tree getRightSon() {
        return right;
    }
    public Tree getLeftSon() {
        return left;
    }
}
