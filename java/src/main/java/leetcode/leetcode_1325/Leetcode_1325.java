package leetcode.leetcode_1325;

// https://leetcode.com/problems/delete-leaves-with-a-given-value/description/?envType=daily-question&envId=2024-05-17
public class Leetcode_1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return root;
        }

        if (!isLeaf(root)) { // 리프가 아니면
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
        }
        if (isLeaf(root) && root.val == target) {
            root = null;
        }
        return root;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
