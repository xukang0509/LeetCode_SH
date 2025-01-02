package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 * 2024-06-13 15:03:03
 */
class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();

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
        public List<Integer> postorderTraversal(TreeNode root) {
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
                    } else {
                        leftRight.right = null;
                        addPath(cur.left, result);
                        cur = cur.right;
                    }
                } else {
                    cur = cur.right;
                }
            }
            addPath(root, result);
            return result;
        }

        private void addPath(TreeNode node, List<Integer> result) {
            int count = 0;
            while (node != null) {
                count++;
                result.add(node.val);
                node = node.right;
            }
            int l = result.size() - count, r = result.size() - 1;
            while (l < r) {
                Integer tmp = result.get(l);
                result.set(l, result.get(r));
                result.set(r, tmp);
                l++;
                r--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}