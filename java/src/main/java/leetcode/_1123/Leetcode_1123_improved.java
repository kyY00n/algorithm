package leetcode._1123;

import java.util.Map;

public class Leetcode_1123_improved {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }

    private Map.Entry<TreeNode, Integer> dfs(TreeNode root) {
        if (root == null) {
            return Map.entry(null, 0);
        }

        Map.Entry<TreeNode, Integer> left = dfs(root.left);
        Map.Entry<TreeNode, Integer> right = dfs(root.right);

        if (left.getValue() > right.getValue()) {
            return Map.entry(left.getKey(), left.getValue() + 1);
        }
        if (left.getValue() < right.getValue()) {
            return Map.entry(right.getKey(), right.getValue() + 1);
        }
        return Map.entry(root, left.getValue() + 1);
    }
}
