package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 二叉树的右视图
 * @author: xu
 * @date: 2026-10-24 10:42:28
 */
@SuppressWarnings("all")
class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offerLast(root);
            while (!deque.isEmpty()) {
                result.add(deque.peekLast().val);
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.pollFirst();
                    if (poll.left != null) deque.offerLast(poll.left);
                    if (poll.right != null) deque.offerLast(poll.right);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}