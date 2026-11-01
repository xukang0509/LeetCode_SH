package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 * 2024-06-13 17:58:07
 */
@SuppressWarnings("ALL")
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0) return null;
            Deque<TreeNode> stack = new LinkedList<>();
            int len = postorder.length;
            TreeNode root = new TreeNode(postorder[len - 1]);
            stack.push(root);
            int index = len - 1;
            for (int i = len - 2; i >= 0; i--) {
                TreeNode node = stack.peek();
                if (node.val != inorder[index]) {
                    node.right = new TreeNode(postorder[i]);
                    stack.push(node.right);
                } else {
                    while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
                        node = stack.pop();
                        index--;
                    }
                    node.left = new TreeNode(postorder[i]);
                    stack.push(node.left);
                }
            }
            return root;
        }

        // ===================================================================================
        public TreeNode buildTree2(int[] inorder, int[] postorder) {
            if (inorder.length == 0) return null;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
        }

        private TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                                   int[] postorder, int postStart, int postEnd,
                                   Map<Integer, Integer> map) {
            if (inStart > inEnd || postStart > postEnd) return null;
            int val = postorder[postEnd];
            TreeNode node = new TreeNode(val);
            int inMid = map.get(val);
            int rightCnt = inEnd - inMid; // 右子树的数量
            node.left = buildTree(inorder, inStart, inMid - 1, postorder, postStart, postEnd - rightCnt - 1, map);
            node.right = buildTree(inorder, inMid + 1, inEnd, postorder, postEnd - rightCnt, postEnd - 1, map);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}