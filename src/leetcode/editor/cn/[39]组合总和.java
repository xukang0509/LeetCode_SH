package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 * 2024-08-16 21:00:41
 */
@SuppressWarnings("all")
class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(0, candidates, target, new LinkedList<>(), result);
            return result;
        }

        private void dfs(int start, int[] candidates, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
            if (target == 0) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                int candidate = candidates[i];
                if (target - candidate < 0) continue;
                stack.push(candidate);
                dfs(i, candidates, target - candidate, stack, result);
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}