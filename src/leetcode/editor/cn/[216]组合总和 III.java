package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 III
 * 2024-08-16 21:27:14
 */
@SuppressWarnings("all")
class CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        List<List<Integer>> list = solution.combinationSum3(3, 9);
        list.forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(1, k, n, new LinkedList<>(), result);
            return result;
        }

        private void dfs(int start, int k, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
            if (target == 0 && stack.size() == k) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = start; i <= 9; i++) {
                if (stack.size() >= k || target < i) continue;
                stack.push(i);
                dfs(i + 1, k, target - i, stack, result);
                stack.pop();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}