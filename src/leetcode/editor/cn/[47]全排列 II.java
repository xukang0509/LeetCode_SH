package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 * 2024-08-15 19:59:13
 */
@SuppressWarnings("all")
class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        List<List<Integer>> list = solution.permuteUnique(new int[]{1, 1, 2});
        System.out.println(list);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            // 对数组进行升序排序
            Arrays.sort(nums);
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
                // 剪枝：这个判断条件保证了对于重复数的集合，一定是从左往右逐个填入的。
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                if (!visited[i]) {
                    visited[i] = true;
                    stack.addLast(nums[i]);
                    dfs(nums, visited, stack, result);
                    // 回溯
                    stack.removeLast();
                    visited[i] = false;
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}