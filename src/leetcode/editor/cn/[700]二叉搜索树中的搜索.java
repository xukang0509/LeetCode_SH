package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * 二叉搜索树中的搜索
 * 2024-06-17 11:40:22
 */
class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree().new Solution();

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
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode node = root;
            while (node != null) {
                if (val > node.val) {
                    node = node.right;
                } else if (val < node.val) {
                    node = node.left;
                } else {
                    break;
                }
            }
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}