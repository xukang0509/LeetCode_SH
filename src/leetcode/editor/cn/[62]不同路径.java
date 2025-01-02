package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 不同路径
 * 2024-08-07 15:21:19
 */
@SuppressWarnings("all")
class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}