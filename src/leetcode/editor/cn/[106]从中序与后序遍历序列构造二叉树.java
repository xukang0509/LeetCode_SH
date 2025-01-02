package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 * 2024-06-13 17:58:07
 */
class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
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
        private Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (postorder.length == 0) return null;
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(inorder, 0, inorder.length,
                    postorder, 0, postorder.length);
        }

        public TreeNode buildTree(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR) {
            if (postL >= postR) return null;
            // 创建根节点
            int rootValue = postorder[postR - 1];
            TreeNode root = new TreeNode(rootValue);
            int i = map.get(rootValue);
            // 切分左右子树
            root.left = buildTree(inorder, inL, i,
                    postorder, postL, postL + i - inL);
            root.right = buildTree(inorder, i + 1, inR,
                    postorder, postL + i - inL, postR - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}