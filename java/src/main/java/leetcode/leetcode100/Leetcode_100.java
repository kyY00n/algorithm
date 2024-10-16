package leetcode.leetcode100;

public class Leetcode_100 {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traverse(p, q);
    }

    private boolean traverse(TreeNode p, TreeNode q) {
        // if p or q is null, we have to check both of the pointers are null.
        if (p == null || q == null) {
            return p == q;
        }
        // if both of the nodes have values, test if the values equal
        if (p.val != q.val) {
            return false;
        }

        // and then check child node, if there is different value, we finally get false.
        return traverse(p.right, q.right) && traverse(p.left, q.left);
    }

}
