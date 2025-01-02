package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * 二叉树展开为链表
 * 2024-06-19 15:39:17
 */
class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();

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
        public void flatten(TreeNode root) {
            for (TreeNode node = root; node != null; node = node.right) {
                if (node.left != null) {
                    TreeNode leftRight = node.left;
                    while (leftRight.right != null) {
                        leftRight = leftRight.right;
                    }
                    leftRight.right = node.right;
                    node.right = node.left;
                    node.left = null;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}