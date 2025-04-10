package leetcode._1123;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Leetcode_1123 {

    private Set<TreeNode> leaves = new HashSet<>();
    private int maxDepth = 0;

    // private int lowestDepth = 0;
    private TreeNode answer = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        rec(root, 0);
        collectLeaves(root, new HashSet<TreeNode>());

        return answer;
    }

    private void rec(TreeNode node, int depth) {
        // edge case
        if (node == null) {
            return;
        }

        // if the node is a leaf
        if (node.left == null && node.right == null) {
            if (maxDepth > depth) {
                return;
            }
            if (maxDepth < depth) {
                maxDepth = depth;
                leaves.clear();
            }
            leaves.add(node);
            return;
        }

        rec(node.left, depth + 1);
        rec(node.right, depth + 1);
    }

    private Set<TreeNode> collectLeaves(TreeNode node, Set<TreeNode> collected) {
        if (node == null) {
            return collected;
        }

        if (answer != null) {
            return collected;
        }

        if (leaves.contains(node)) {
            collected.add(node);
            if (collected.size() == leaves.size()) {
                answer = node;
            }
            return collected;
        }

        Set<TreeNode> leftCollected = collectLeaves(node.left, new HashSet<>(collected));
        Set<TreeNode> rightCollected = collectLeaves(node.right, new HashSet<>(collected));

        if (answer != null) {
            return leaves;
        }

        if (leftCollected.size() + rightCollected.size() == leaves.size()) {
            answer = node;
            return leaves;
        }

        leftCollected.addAll(rightCollected);
        return leftCollected;
    }
}
