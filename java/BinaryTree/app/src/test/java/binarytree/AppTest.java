/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package binarytree;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void testEmptyTree() {
        BinarySearchTree bst = new BinarySearchTree();
        assertTrue(bst.preOrder().isEmpty());
        assertTrue(bst.inOrder().isEmpty());

        assertTrue(bst.postOrder().isEmpty());
    }

    @Test
    public void testSingleNodeTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        List<Integer> preOrder = bst.preOrder();
        List<Integer> inOrder = bst.inOrder();
        List<Integer> postOrder = bst.postOrder();

        assertEquals(1, preOrder.size());
        assertEquals(1, inOrder.size());

        assertEquals(1, postOrder.size());
        assertEquals(Integer.valueOf(10), preOrder.get(0));
        assertEquals(Integer.valueOf(10), inOrder.get(0));
        assertEquals(Integer.valueOf(10), postOrder.get(0));
    }

    @Test
    public void testAddLeftAndRightChild() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        List<Integer> preOrder = bst.preOrder();
        List<Integer> inOrder = bst.inOrder();
        List<Integer> postOrder = bst.postOrder();

        assertEquals(3, preOrder.size());
        assertEquals(Integer.valueOf(10), preOrder.get(0));
        assertEquals(Integer.valueOf(15), inOrder.get(2));
        assertEquals(Integer.valueOf(10), postOrder.get(2));
    }

    @Test
    public void testContainsMethod() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(5));
        assertTrue(bst.contains(15));
        assertFalse(bst.contains(7));
        assertFalse(bst.contains(20));
    }
    @Test
    public void testFindMaximumValueNode() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);

        int maxValue = tree.findMaximumValue();
        assertEquals(10, maxValue);
    }

    @Test
    public void testFindMaximumValueNodes() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(7);
        tree.root.right.left = new Node(12);
        tree.root.right.right = new Node(20);

        int maxValue = tree.findMaximumValue();
        assertEquals(20, maxValue);
    }



}
