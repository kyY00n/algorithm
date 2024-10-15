package leetcode.leetcode94;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Leetcode_94 {

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

        private List<Integer> answer = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) { // edge case - when `root` is null
                return Collections.emptyList();
            }
            inorder(root);
            return answer;
        }

        private void inorder(TreeNode curr) {
            if (curr.left != null) {
                inorder(curr.left);
            }
            answer.add(curr.val);
            if (curr.right != null) {
                inorder(curr.right);
            }
        }

        public List<Integer> inorderTraversal_iterative(TreeNode root) {
            if (root == null) { // edge case - when `root` is null
                return Collections.emptyList();
            }

            Stack<TreeNode> stack = new Stack<>();
            Set<TreeNode> visited = new HashSet<>();
            stack.push(root);

            List<Integer> answer = new ArrayList<>();

            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                if (visited.contains(curr)) {
                    answer.add(curr.val);
                    continue;
                }
                visited.add(curr);
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                stack.push(curr);
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }

            return answer;
        }

    }

}
