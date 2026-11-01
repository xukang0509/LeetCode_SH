package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 617 合并二叉树 merge-two-binary-trees
 * @author: xu
 * @date: 2026-11-01 20:06:53
 */
@SuppressWarnings("all")
class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
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
        // bfs 原地操作
        public TreeNode mergeTrees4(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) return null;
            if (root1 == null) return root2;
            if (root2 == null) return root1;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root1);
            queue.offer(root2);
            while (!queue.isEmpty()) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();
                node1.val = node1.val + node2.val;
                if (node1.left == null) {
                    node1.left = node2.left;
                } else if (node1.left != null && node2.left != null) {
                    queue.offer(node1.left);
                    queue.offer(node2.left);
                }
                if (node1.right == null) {
                    node1.right = node2.right;
                } else if (node1.right != null && node2.right != null) {
                    queue.offer(node1.right);
                    queue.offer(node2.right);
                }
            }
            return root1;
        }

        // ===================================================================================
        // bfs 维护新节点
        public TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) return null;
            if (root1 == null) return root2;
            if (root2 == null) return root1;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root1);
            queue.offer(root2);
            TreeNode root = new TreeNode(root1.val + root2.val);
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();
                TreeNode newNode = queue.poll();
                if (node1.left != null || node2.left != null) {
                    if (node1.left != null && node2.left != null) {
                        newNode.left = new TreeNode(node1.left.val + node2.left.val);
                        queue.offer(node1.left);
                        queue.offer(node2.left);
                        queue.offer(newNode.left);
                    } else if (node1.left == null) {
                        newNode.left = node2.left;
                    } else {
                        newNode.left = node1.left;
                    }
                }
                if (node1.right != null || node2.right != null) {
                    if (node1.right != null && node2.right != null) {
                        newNode.right = new TreeNode(node1.right.val + node2.right.val);
                        queue.offer(node1.right);
                        queue.offer(node2.right);
                        queue.offer(newNode.right);
                    } else if (node1.right == null) {
                        newNode.right = node2.right;
                    } else {
                        newNode.right = node1.right;
                    }
                }
            }
            return root;
        }

        // ================================================================================
        // dfs
        public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) return null;
            if (root1 == null) return root2;
            if (root2 == null) return root1;
            return new TreeNode(root1.val + root2.val,
                    mergeTrees2(root1.left, root2.left),
                    mergeTrees2(root1.right, root2.right));
        }

        // dfs
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) return root2;
            if (root2 == null) return root1;
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}