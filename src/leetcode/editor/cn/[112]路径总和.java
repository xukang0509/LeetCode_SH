package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: 112 路径总和 path-sum
 * @author: xu
 * @date: 2026-10-28 22:10:06
 */
@SuppressWarnings("all")
class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
        // TO TEST
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            if (root.left == null && root.right == null) return root.val == targetSum;
            if (hasPathSum(root.left, targetSum - root.val)) return true;
            if (hasPathSum(root.right, targetSum - root.val)) return true;
            return false;
        }

        // ================================================================================
        public boolean hasPathSum2(TreeNode root, int targetSum) {
            if (root == null) return false;
            Deque<TreeNode> nodeQueue = new ArrayDeque<>();
            Deque<Integer> sumQueue = new ArrayDeque<>();
            nodeQueue.offer(root);
            sumQueue.offer(root.val);
            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                Integer val = sumQueue.poll();
                if (node.left == null && node.right == null && val == targetSum) return true;
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    sumQueue.offer(val + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    sumQueue.offer(val + node.right.val);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}