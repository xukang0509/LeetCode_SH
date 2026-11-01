package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * 2024-06-13 17:58:05
 */
@SuppressWarnings("ALL")
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) return null;
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode root = new TreeNode(preorder[0]);
            stack.push(root);
            int index = 0;
            for (int i = 1; i < preorder.length; i++) {
                TreeNode node = stack.peek();
                if (node.val != inorder[index]) {
                    node.left = new TreeNode(preorder[i]);
                    stack.push(node.left);
                } else {
                    while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
                        node = stack.pop();
                        index++;
                    }
                    node.right = new TreeNode(preorder[i]);
                    stack.push(node.right);
                }
            }
            return root;
        }

        //=================================================================================
        public TreeNode buildTree2(int[] preorder, int[] inorder) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                   int[] inorder, int inStart, int inEnd,
                                   Map<Integer, Integer> map) {
            if (preStart > preEnd || inStart > inEnd) return null;
            int val = preorder[preStart];
            int inMid = map.get(val);
            TreeNode newNode = new TreeNode(val);
            newNode.left = buildTree(preorder, preStart + 1, inMid - inStart + preStart, inorder, inStart, inMid - 1, map);
            newNode.right = buildTree(preorder, inMid - inStart + preStart + 1, preEnd, inorder, inMid + 1, inEnd, map);
            return newNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}