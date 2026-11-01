package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 654 最大二叉树 maximum-binary-tree
 * @author: xu
 * @date: 2026-10-29 00:44:08
 */
@SuppressWarnings("all")
class MaximumBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumBinaryTree().new Solution();
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
        // todo 单调栈
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offerLast(new TreeNode(nums[0]));
            for (int i = 1; i < nums.length; i++) {
                TreeNode node = null;
                TreeNode newNode = new TreeNode(nums[i]);
                while (!deque.isEmpty() && deque.peekLast().val < newNode.val) {
                    node = deque.pollLast();
                }
                newNode.left = node;
                if (!deque.isEmpty()) deque.peekLast().right = newNode;
                deque.offerLast(newNode);
            }
            return deque.peekFirst();
        }
        
        // =======================================================================================================
        public TreeNode constructMaximumBinaryTree2(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            return constructMaximumBinaryTree(nums, 0, nums.length);
        }

        // [start, end)
        public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
            if (start >= end) return null;
            int maxValIndex = findMaxValIndex(nums, start, end);
            TreeNode node = new TreeNode(nums[maxValIndex]);
            node.left = constructMaximumBinaryTree(nums, start, maxValIndex);
            node.right = constructMaximumBinaryTree(nums, maxValIndex + 1, end);
            return node;
        }

        // [l, r)
        private int findMaxValIndex(int[] nums, int l, int r) {
            int maxIndex = l;
            for (int i = l + 1; i < r; i++) {
                if (nums[maxIndex] < nums[i]) {
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}