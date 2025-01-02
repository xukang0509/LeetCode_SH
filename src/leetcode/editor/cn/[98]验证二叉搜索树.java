package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 验证二叉搜索树
 * 2024-06-17 11:45:52
 */
class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();

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
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            return isValidBST(root, new AtomicLong(Long.MIN_VALUE));
        }

        public boolean isValidBST(TreeNode node, AtomicLong prev) {
            if (node == null) return true;
            boolean a = isValidBST(node.left, prev);
            if (!a || prev.get() >= node.val) return false;
            prev.set(node.val);
            return isValidBST(node.right, prev);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}