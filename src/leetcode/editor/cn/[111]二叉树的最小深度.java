package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * 二叉树的最小深度
 * 2024-06-13 16:03:23
 */
class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            int d1 = minDepth(root.left);
            int d2 = minDepth(root.right);
            if (d1 == 0 || d2 == 0) {
                return 1 + d1 + d2;
            }
            return Integer.min(d1, d2) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}