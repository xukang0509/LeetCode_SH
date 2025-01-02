package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * 二叉搜索树的范围和
 * 2024-06-17 14:05:36
 */
class RangeSumOfBst {
    public static void main(String[] args) {
        Solution solution = new RangeSumOfBst().new Solution();

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
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) return 0;
            if (low > root.val) return rangeSumBST(root.right, low, high);
            if (high < root.val) return rangeSumBST(root.left, low, high);
            return root.val + rangeSumBST(root.left, low, high)
                    + rangeSumBST(root.right, low, high);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}