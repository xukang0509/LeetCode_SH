package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 验证二叉搜索树
 * 2024-06-17 11:45:52
 */
@SuppressWarnings("ALL")
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
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode root, long lower, long upper) {
            if (root == null) return true;
            if (root.val <= lower || root.val >= upper) return false;
            return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
        }

        // ======================================================================================
        private TreeNode pre = null;

        public boolean isValidBST4(TreeNode root) {
            if (root == null) return true;
            boolean flg = isValidBST4(root.left);
            if (!flg || (pre != null && pre.val >= root.val)) return false;
            pre = root;
            return isValidBST4(root.right);
        }

        // ==============================================================================
        public boolean isValidBST3(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode node = root;
            TreeNode pre = null;
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    if (pre != null && pre.val >= node.val) return false;
                    pre = node;
                    node = node.right;
                }
            }
            return true;
        }

        // ==========================================================================

        public boolean isValidBST2(TreeNode root) {
            return isValidBST(root, new AtomicLong(Long.MIN_VALUE));
        }

        private boolean isValidBST(TreeNode node, AtomicLong pre) {
            if (node == null) return true;
            boolean flg = isValidBST(node.left, pre);
            if (!flg || pre.get() >= node.val) return false;
            pre.set(node.val);
            return isValidBST(node.right, pre);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}