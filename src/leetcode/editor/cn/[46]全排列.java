package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 2024-08-15 19:41:01
 */
@SuppressWarnings("all")
class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});
        permute.forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(nums, new boolean[nums.length], new LinkedList<>(), result);
            return result;
        }

        private void dfs(int[] nums, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> result) {
            if (stack.size() == nums.length) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    stack.push(nums[i]);
                    dfs(nums, visited, stack, result);
                    stack.pop();
                    visited[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}