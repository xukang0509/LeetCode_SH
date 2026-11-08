package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: 530 二叉搜索树的最小绝对差 minimum-absolute-difference-in-bst
 * @author: xu
 * @date: 2026-11-01 22:00:29
 */
@SuppressWarnings("all")
class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
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

        private TreeNode prev;
        private int min;

        public int getMinimumDifference(TreeNode root) {
            prev = null;
            min = Integer.MAX_VALUE;
            dfs(root);
            return min;
        }

        public void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            if (prev != null) {
                min = Math.min(min, root.val - prev.val);
            }
            prev = root;
            dfs(root.right);
        }

        // ========================================================================
        public int getMinimumDifference2(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode curr = root, prev = null;
            int min = Integer.MAX_VALUE;
            while (!stack.isEmpty() || curr != null) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    if (prev != null) {
                        min = Math.min(min, curr.val - prev.val);
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}