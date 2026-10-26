package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 在每个树行中找最大值
 * @author: xu
 * @date: 2026-10-24 13:35:53
 */
@SuppressWarnings("all")
class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution solution = new FindLargestValueInEachTreeRow().new Solution();
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
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            dfs(root, result, 0);
            return result;
        }

        private void dfs(TreeNode node, List<Integer> nums, int depth) {
            if (node == null) return;
            if (depth == nums.size()) {
                nums.add(node.val);
            } else {
                nums.set(depth, Math.max(nums.get(depth), node.val));
            }
            dfs(node.left, nums, depth + 1);
            dfs(node.right, nums, depth + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}