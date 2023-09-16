package binarytree;

public class BinarySearchTree extends BinaryTree{
    public void add(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null) {return new Node(value);}
        if (value < root.value)
        {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }

        return root;
    }


    public boolean contains(int value) {
        return search(root, value);
    }

    private boolean search(Node root, int value) {
        if (root == null) {
            return false;}

        if (root.value == value) {
            return true;}

        if (value < root.value) {
            return search(root.left, value);
        } else {

            return search(root.right, value);
        }
    }


}
