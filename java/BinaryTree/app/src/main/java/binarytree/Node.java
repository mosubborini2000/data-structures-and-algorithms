package binarytree;

public class Node {
    int value;

    public int getKey() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    Node left;Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;this.right = null;
    }
}

