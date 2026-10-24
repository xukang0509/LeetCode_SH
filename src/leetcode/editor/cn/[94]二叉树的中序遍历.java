package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * 2024-06-13 15:02:58
 */
@SuppressWarnings("ALL")
class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node2.left = node3;
        node1.right = node2;

        solution.inorderTraversal(node1);
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
        /*
                 5
                /  \
               4    6
              / \
             1   2
         */
        // 中序 1 4 2 5 6
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            TreeNode curr = root;
            while (curr != null) {
                if (curr.left != null) {
                    TreeNode rightMost = curr.left;
                    while (rightMost.right != null && rightMost.right != curr) {
                        rightMost = rightMost.right;
                    }
                    if (rightMost.right == null) {
                        rightMost.right = curr;
                        curr = curr.left;
                    } else {
                        result.add(curr.val);
                        rightMost.right = null;
                        curr = curr.right;
                    }
                } else {
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}