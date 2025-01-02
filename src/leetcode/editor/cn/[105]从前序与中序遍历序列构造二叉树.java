package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * 2024-06-13 17:58:05
 */
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        //solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) return null;
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        public TreeNode buildTree(int[] preOrder, int preL, int preR, int[] inOrder, int inL, int inR) {
            if (preL >= preR) return null;
            // 创建根节点
            int rootValue = preOrder[preL];
            TreeNode root = new TreeNode(rootValue);
            int i = map.get(rootValue);
            // 切分左右子树
            root.left = buildTree(preOrder, preL + 1, preL + 1 + i - inL,
                    inOrder, inL, i);
            root.right = buildTree(preOrder, preL + 1 + i - inL, preR,
                    inOrder, i + 1, inR);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}