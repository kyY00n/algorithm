package leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Leetcode_111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode, Integer> nodeToDepth = new HashMap<>();
        queue.offer(root);
        nodeToDepth.put(root, 1);

        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            TreeNode polled = queue.poll();
            int depth = nodeToDepth.get(polled);
            if (polled.left == null && polled.right == null) {
                answer = Math.min(answer, depth);
                break;
            }
            if (polled.left != null) {
                nodeToDepth.put(polled.left, depth + 1);
                queue.offer(polled.left);
            }
            if (polled.right != null) {
                nodeToDepth.put(polled.right, depth + 1);
                queue.offer(polled.right);
            }
        }
        return answer;
    }

    public class TreeNode {

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
