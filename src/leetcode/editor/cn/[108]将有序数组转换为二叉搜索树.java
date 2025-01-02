package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 * 2024-06-22 11:07:26
 */
class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();

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
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
            if (left > right) return null;
            // 选择中间位置左边的数字作为根节点
            int mid = (left + right) >>> 1;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBST(nums, left, mid - 1);
            node.right = sortedArrayToBST(nums, mid + 1, right);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}