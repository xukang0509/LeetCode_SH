package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将二叉搜索树变平衡
 * 2024-06-22 11:08:36
 */
class BalanceABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new BalanceABinarySearchTree().new Solution();

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
        List<Integer> list = new ArrayList<>();

        public TreeNode balanceBST(TreeNode root) {
            inOrder(root);
            return buildTree(list, 0, list.size() - 1);
        }

        public TreeNode buildTree(List<Integer> arr, int left, int right) {
            if (left > right) return null;
            int mid = (left + right) >>> 1;
            TreeNode node = new TreeNode(arr.get(mid));
            node.left = buildTree(arr, left, mid - 1);
            node.right = buildTree(arr, mid + 1, right);
            return node;
        }

        private void inOrder(TreeNode node) {
            if (node == null) return;
            inOrder(node.left);
            list.add(node.val);
            inOrder(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}