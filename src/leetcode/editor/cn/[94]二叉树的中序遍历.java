package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * 2024-06-13 15:02:58
 */
class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();

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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            TreeNode cur = root, leftRight = null;
            while (cur != null) {
                if (cur.left != null) {
                    leftRight = cur.left;
                    while (leftRight.right != null && leftRight.right != cur) {
                        leftRight = leftRight.right;
                    }
                    if (leftRight.right == null) {
                        leftRight.right = cur;
                        cur = cur.left;
                        continue;
                    } else {
                        result.add(cur.val);
                        leftRight.right = null;
                    }
                } else {
                    result.add(cur.val);
                }
                cur = cur.right;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}