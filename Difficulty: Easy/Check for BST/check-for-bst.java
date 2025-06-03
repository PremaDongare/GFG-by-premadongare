class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isBSTUtil(Node node, long lowerbound, long upperbound) {
        if (node == null) {
            return true;
        }

        if (node.data <= lowerbound || node.data >= upperbound) {
            return false;
        }

        return isBSTUtil(node.left, lowerbound, node.data) &&
               isBSTUtil(node.right, node.data, upperbound);
    }
}
