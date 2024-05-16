package leetcode.leetcode2331;

// https://leetcode.com/problems/evaluate-boolean-binary-tree/description/?envType=daily-question&envId=2024-05-16
public class Leetcode_2331 {
    public boolean evaluateTree(TreeNode root) {
        switch (root.val) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return evaluateTree(root.left) || evaluateTree(root.right);
            default:
                return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }

}
