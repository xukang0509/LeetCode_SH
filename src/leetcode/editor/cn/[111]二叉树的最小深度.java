package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * 二叉树的最小深度
 * 2024-06-13 16:03:23
 */
@SuppressWarnings("ALL")
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
        /*
         * 1.当前节点为空，返回0
         * 2.当前节点的左右节点都为空时，返回1
         * 3.当前节点的左右节点有一个不为空，返回不为空节点的深度
         * 4.当前节点的左右节点都不为空时，返回左右节点较小深度
         * 其中2、3视为一种情况，4视为另一种情况
         */
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            int m1 = minDepth(root.left);
            int m2 = minDepth(root.right);
            return (root.left != null && root.right != null) ? Math.min(m1, m2) + 1 : m1 + m2 + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}