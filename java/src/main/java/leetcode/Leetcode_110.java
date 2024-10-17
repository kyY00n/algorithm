package leetcode;

public class Leetcode_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) { // we need to test if the root is null
            return true; // we can see that the empty tree is balanced in the example.
        }
        int hi = height(root);
        if (hi == -1) { // if the height is -1, it means that the tree is not balanced.
            return false;
        }
        return true;
    }

    private int height(TreeNode node) {
        if (node == null) { // if the node is null, the height is 0.
            return 0;
        }
        int left = height(node.left); // get the height of the left child node
        int right = height(node.right); // get the height of the right child node
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
            // if the difference between the left height and right height is bigger than one, then this tree is not balanced, so return -1.
            // If the left or right height is -1, we have to return -1 as well.
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

}
