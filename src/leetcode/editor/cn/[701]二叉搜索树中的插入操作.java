package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * 二叉搜索树中的插入操作
 * 2024-06-17 11:30:32
 */
class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();

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
        public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode node = root;
            TreeNode parent = null;
            while (node != null) {
                parent = node;
                if (val > node.val) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
            TreeNode newNode = new TreeNode(val);
            if (parent == null) {
                root = newNode;
            } else if (val > parent.val) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}