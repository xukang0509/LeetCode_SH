package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * 二叉搜索树中的搜索
 * 2024-06-17 11:40:22
 */
@SuppressWarnings("ALL")
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
        // 递归
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || root.val == val) return root;
            return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
        }

        // 迭代
        public TreeNode searchBST2(TreeNode root, int val) {
            TreeNode node = root;
            while (node != null) {
                if (node.val > val) {
                    node = node.left;
                } else if (node.val < val) {
                    node = node.right;
                } else {
                    break;
                }
            }
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}