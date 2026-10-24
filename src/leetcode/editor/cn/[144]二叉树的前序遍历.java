package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * 2024-06-13 15:03:01
 */
@SuppressWarnings("ALL")
class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node2.left = node3;
        node1.right = node2;

        solution.preorderTraversal(node1);
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
        // 前序 5 4 1 2 6
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            TreeNode curr = root;
            while (curr != null) {
                if (curr.left != null) {
                    TreeNode rightMost = curr.left;
                    while (rightMost.right != null && rightMost.right != curr) {
                        rightMost = rightMost.right;
                    }
                    if (rightMost.right == null) {
                        res.add(curr.val);
                        rightMost.right = curr;
                        curr = curr.left;
                    } else {
                        rightMost.right = null;
                        curr = curr.right;
                    }
                } else {
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}