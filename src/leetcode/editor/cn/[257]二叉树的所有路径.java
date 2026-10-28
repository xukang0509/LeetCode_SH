package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 257 二叉树的所有路径 binary-tree-paths
 * @author: xu
 * @date: 2026-10-27 21:52:26
 */
@SuppressWarnings("all")
class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) return result;
            List<Integer> path = new ArrayList<>();
            addString(root, path, result);
            return result;
        }

        private void addString(TreeNode node, List<Integer> path, List<String> result) {
            path.add(node.val);
            if (node.left == null && node.right == null) {
                StringBuilder builder = new StringBuilder();
                builder.append(path.get(0));
                for (int i = 1; i < path.size(); i++) {
                    builder.append("->").append(path.get(i));
                }
                result.add(builder.toString());
                return;
            }
            if (node.left != null) {
                addString(node.left, path, result);
                path.remove(path.size() - 1);
            }
            if (node.right != null) {
                addString(node.right, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}