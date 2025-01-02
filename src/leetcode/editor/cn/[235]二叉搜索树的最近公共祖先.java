package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 * 2024-06-19 15:27:24
 */
class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinarySearchTree().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode node = root;
            while (node != null) {
                if (node.val > p.val && node.val > q.val) {
                    node = node.left;
                } else if (node.val < p.val && node.val < q.val) {
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