package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 113 路径总和 II path-sum-ii
 * @author: xu
 * @date: 2026-10-31 16:33:05
 */
@SuppressWarnings("all")
class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            List<Integer> path = new ArrayList<>();
            pathSum(root, targetSum, result, path);
            return result;
        }

        private void pathSum(TreeNode node, final int targetSum, List<List<Integer>> pathSums, List<Integer> path) {
            path.add(node.val);
            if (node.left == null && node.right == null && targetSum == node.val) {
                pathSums.add(new ArrayList<>(path));
                return;
            }
            if (node.left != null) {
                pathSum(node.left, targetSum - node.val, pathSums, path);
                path.remove(path.size() - 1);
            }
            if (node.right != null) {
                pathSum(node.right, targetSum - node.val, pathSums, path);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}