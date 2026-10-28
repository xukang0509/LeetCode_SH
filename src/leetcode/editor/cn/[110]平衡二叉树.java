package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * @Description: 110 平衡二叉树 balanced-binary-tree
 * @author: xu
 * @date: 2026-10-27 21:20:45
 */
@SuppressWarnings("all")
class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
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
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }

        // 如果是平衡二叉树，返回其高度，否则返回-1
        private int getHeight(TreeNode node) {
            if (node == null) return 0;
            int leftHeight = getHeight(node.left);
            if (leftHeight == -1) return -1;
            int rightHeight = getHeight(node.right);
            if (rightHeight == -1) return -1;
            return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}