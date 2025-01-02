package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 对称二叉树
 * 2024-06-13 15:22:39
 */
class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();

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
        public boolean isSymmetric(TreeNode root) {
            if (root.left == null && root.right == null) return true;
            if (root.left == null || root.right == null) return false;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);
            while (!queue.isEmpty()) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                //如果两个节点都为空就继续循环，两者有一个为空就返回false
                if (left == null && right == null) continue;
                if (left == null || right == null) return false;
                if (left.val != right.val) return false;

                //将左节点的左孩子，右节点的右孩子放入队列
                queue.offer(left.left);
                queue.offer(right.right);
                //将左节点的右孩子，右节点的左孩子放入队列
                queue.offer(left.right);
                queue.offer(right.left);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}