package hashtable;

import java.util.HashSet;
import java.util.Set;

public class TreeIntersection<T> {
    public Set<T> tree_intersection(BinaryTree<T> tree1, BinaryTree<T> tree2) {
        Set<T> commonValues = new HashSet<>();
        Set<T> valuesInTree1 = new HashSet<>();
        traverseTree(tree1, valuesInTree1);

        traverseAndCheck(tree2, valuesInTree1, commonValues);

        return commonValues;
    }

    private void traverseTree(BinaryTree<T> node, Set<T> values) {
        if (node == null) {
            return;
        }
        values.add(node.value);
        traverseTree(node.left, values);
        traverseTree(node.right, values);
    }

    private void traverseAndCheck(BinaryTree<T> node, Set<T> valuesToCheck, Set<T> commonValues) {
        if (node == null) {
            return;
        }
        if (valuesToCheck.contains(node.value)) {
            commonValues.add(node.value);
        }
        traverseAndCheck(node.left, valuesToCheck, commonValues);
        traverseAndCheck(node.right, valuesToCheck, commonValues);
    }
}
