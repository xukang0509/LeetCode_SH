package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * 前序遍历构造二叉搜索树
 * 2024-06-17 14:21:33
 */
class ConstructBinarySearchTreeFromPreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinarySearchTreeFromPreorderTraversal().new Solution();
        TreeNode node = solution.bstFromPreorder(new int[]{4, 2});
        System.out.println("node = " + node);
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
        public TreeNode bstFromPreorder(int[] preorder) {
            return bstFromPreorder(preorder, 0, preorder.length - 1);
        }

        private TreeNode bstFromPreorder(int[] preorder, int low, int high) {
            if (low > high) return null;
            if (low == high) return new TreeNode(preorder[low]);
            int partition = find(preorder, low, high);
            TreeNode root = new TreeNode(preorder[low]);
            root.left = bstFromPreorder(preorder, low + 1, partition);
            root.right = bstFromPreorder(preorder, partition + 1, high);
            return root;
        }

        private int find(int[] array, int low, int high) {
            int i = low + 1;
            while (i <= high) {
                if (array[i] > array[low]) {
                    break;
                }
                i++;
            }
            return i - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}