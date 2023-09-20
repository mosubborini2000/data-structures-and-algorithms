package stackandqueue.binarytree;

import stackandqueue.Queue.Queue;

import java.util.ArrayList;

import java.util.List;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }


    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(root, result);
        return result;
    }

    private void preOrderTraversal(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            preOrderTraversal(node.left, result);
            preOrderTraversal(node.right, result);
        }
    }


    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(Node node, List<Integer> result) {
        if (node != null) {
            inOrderTraversal(node.left, result);
            result.add(node.value);
            inOrderTraversal(node.right, result);}
    }
    private void postOrderTraversal(Node node, List<Integer> result) {
        if (node != null) {
            postOrderTraversal(node.left, result);
            postOrderTraversal(node.right, result);
            result.add(node.value);
        }
    }
    public List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }
    public int findMaximumValue() {
        if (root == null) {
            throw new IllegalStateException("The tereee is empty");
        }
        return findMaximumValue(root);
    }
    private int findMaximumValue(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int currentValue = node.value;
        int leftMax = findMaximumValue(node.left);
        int rightMax = findMaximumValue(node.right);
        int max1=Math.max(leftMax,rightMax);
        int max2=Math.max(currentValue,max1);
        return max2;
    }

        public List<Integer> breadthFirst() throws Exception {
            List<Integer> result = new ArrayList<>();
            Queue<Node> queue = new Queue<>();
            if (root == null) {
                return result;
            }
            queue.enqueue(root);
            while (!queue.isEmpty()) {
                Node node = queue.dequeue();
                result.add(node.value);
                if (node.left != null) {
                    queue.enqueue(node.left);
                }
                if (node.right != null) {
                    queue.enqueue(node.right);
                }
            }

            return result;
        }

}
