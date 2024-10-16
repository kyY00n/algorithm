package leetcode;


public class Leetcode_101 {

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

    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;

        // we have to check the symmetrical value, so pass each pointer of nodes
        return isSame(left, right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        // if one of the given pointers is null
        if (left == null || right == null) {
            return left == right; // return if the pointers equal or not.
        }

        // if the values of each node doesn't equal
        if (left.val != right.val) {
            return false; // return false.
        }

        // return the result of child nodes comparison. if there is non-symmetric values in child tree, it returns false.
        return isSame(left.right, right.left) && isSame(left.left, right.right);
    }

}
