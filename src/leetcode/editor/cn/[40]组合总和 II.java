package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 II
 * 2024-08-16 21:12:59
 */
@SuppressWarnings("all")
class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<>();
            dfs(0, candidates, new boolean[candidates.length], target, new LinkedList<>(), result);
            return result;
        }

        private void dfs(int start, int[] candidates, boolean[] visited, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
            if (target == 0) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                int candidate = candidates[i];
                // 剪枝条件
                if (target < candidate) continue;
                if (i > 0 && candidate == candidates[i - 1] && !visited[i - 1]) continue;
                stack.push(candidate);
                visited[i] = true;
                dfs(i + 1, candidates, visited, target - candidate, stack, result);
                visited[i] = false;
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}