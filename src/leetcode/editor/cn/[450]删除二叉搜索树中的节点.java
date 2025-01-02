package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

/**
 * 删除二叉搜索树中的节点
 * 2024-06-17 10:54:06
 */
class DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();

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
        public TreeNode deleteNode(TreeNode root, int key) {
            // 找对应的node节点及其父节点
            TreeNode node = root;
            TreeNode parent = null;
            while (node != null) {
                if (key > node.val) {
                    parent = node;
                    node = node.right;
                } else if (key < node.val) {
                    parent = node;
                    node = node.left;
                } else {
                    break;
                }
            }
            if (node == null) return root;

            TreeNode tmp = null;
            // 处理度为2的节点
            if (node.left != null && node.right != null) {
                parent = node;
                tmp = node.right;
                while (tmp.left != null) {
                    parent = tmp;
                    tmp = tmp.left;
                }
                node.val = tmp.val;
                node = tmp;
            }

            tmp = node.left == null ? node.right : node.left;
            if (parent == null) {
                root = tmp;
            } else if (parent.left == node) {
                parent.left = tmp;
            } else {
                parent.right = tmp;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}