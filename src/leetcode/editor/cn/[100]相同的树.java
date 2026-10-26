package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 100 相同的树 same-tree
 * @author: xu
 * @date: 2026-10-25 13:47:52
 */
@SuppressWarnings("all")
class SameTree {
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(p);
            queue.offer(q);
            while (!queue.isEmpty()) {
                p = queue.poll();
                q = queue.poll();
                if (p == null && q == null) continue;
                if (p == null || q == null || p.val != q.val) return false;

                queue.offer(p.left);
                queue.offer(q.left);
                queue.offer(p.right);
                queue.offer(q.right);
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}