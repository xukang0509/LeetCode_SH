package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: 513 找树左下角的值 find-bottom-left-tree-value
 * @author: xu
 * @date: 2026-10-28 21:32:55
 */
@SuppressWarnings("all")
class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        private int maxCount;
        private int leftValue;

        public int findBottomLeftValue(TreeNode root) {
            maxCount = -1;
            leftValue = root.val;
            dfs(root, 1);
            return leftValue;
        }

        private void dfs(TreeNode node, int count) {
            if (node == null) return;
            if (isLeafNode(node)) {
                if (maxCount < count) {
                    maxCount = count;
                    leftValue = node.val;
                }
                return;
            }
            dfs(node.left, count + 1);
            dfs(node.right, count + 1);
        }

        private boolean isLeafNode(TreeNode node) {
            return node.left == null && node.right == null;
        }

        // ========================================================
        public int findBottomLeftValue2(TreeNode root) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            TreeNode node = root;
            queue.offer(node);
            while (!queue.isEmpty()) {
                int size = queue.size();
                node = queue.poll();
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
            return node.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}