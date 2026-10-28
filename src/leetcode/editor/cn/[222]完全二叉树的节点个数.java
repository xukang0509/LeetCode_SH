package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * @Description: 222 完全二叉树的节点个数 count-complete-tree-nodes
 * @author: xu
 * @date: 2026-10-26 20:04:18
 */
@SuppressWarnings("all")
class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
        // TO TEST
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null));
        System.out.println("solution.countNodes(root) = " + solution.countNodes(root));
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
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            int h = 0;
            TreeNode p = root;
            while (p.left != null) {
                h++;
                p = p.left;
            }
            int low = 1 << h, high = (1 << (h + 1));
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (exists(root, h, mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low - 1;
        }

        private boolean exists(TreeNode node, int h, int mid) {
            int b = 1 << (h - 1);
            while (node != null && b > 0) {
                if ((b & mid) == 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
                b >>>= 1;
            }
            return node != null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}