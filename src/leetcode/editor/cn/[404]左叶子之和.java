package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: 404 左叶子之和 sum-of-left-leaves
 * @author: xu
 * @date: 2026-10-28 21:01:56
 */
@SuppressWarnings("all")
class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));
        System.out.println("solution.sumOfLeftLeaves(root) = " + solution.sumOfLeftLeaves(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

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
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int ans = 0;
            if (root.left != null) {
                ans += isLeafNode(root.left) ? root.left.val : sumOfLeftLeaves(root.left);
            }
            if (root.right != null && !isLeafNode(root.right)) {
                ans += sumOfLeftLeaves(root.right);
            }
            return ans;
        }

        private boolean isLeafNode(TreeNode node) {
            return node.left == null && node.right == null;
        }

        // ==============================================================================
        public int sumOfLeftLeaves2(TreeNode root) {
            int ans = 0;
            if (root == null || isLeafNode(root)) return ans;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (isLeafNode(node.left)) {
                        ans += node.left.val;
                    } else {
                        queue.offer(node.left);
                    }
                }
                if (node.right != null) {
                    if (!isLeafNode(node.right)) {
                        queue.offer(node.right);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}