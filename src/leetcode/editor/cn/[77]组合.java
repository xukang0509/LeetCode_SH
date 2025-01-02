package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 2024-08-16 20:36:01
 */
@SuppressWarnings("all")
class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        List<List<Integer>> combine = solution.combine(6, 4);
        combine.forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(1, n, k, new ArrayList<>(), result);
            return result;
        }

        private void dfs(int start, int n, int k, ArrayList<Integer> stack, List<List<Integer>> result) {
            if (0 == k) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = start; i <= n; i++) {
                if (k > n - i + 1) {
                    continue;
                }
                stack.add(i);
                dfs(i + 1, n, k - 1, stack, result);
                stack.remove(stack.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}