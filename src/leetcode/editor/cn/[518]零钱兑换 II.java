package leetcode.editor.cn;

/**
 * 零钱兑换 II
 * 2024-08-04 13:50:33
 */
@SuppressWarnings("all")
class CoinChangeIi {
    public static void main(String[] args) {
        Solution solution = new CoinChangeIi().new Solution();
        System.out.println(solution.change(5, new int[]{5, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
         * dp[i][j]：在总金额为j时，持有硬币coins[0...i-1]时的可以凑成总金额的硬币组合数
         *
         * 初始化：dp[i][0] = 1
         * 状态方程：
         * if(j >= coins[i]) { // 放得下
         *      dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]
         * } else { // 放不下
         *      dp[i][j] = dp[i-1][j]
         * }
         * */
        public int change(int amount, int[] coins) {
            int[][] dp = new int[coins.length + 1][amount + 1];
            for (int i = 0; i < coins.length + 1; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < coins.length + 1; i++) {
                int coin = coins[i - 1];
                for (int j = 1; j < amount + 1; j++) {
                    if (j >= coin) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[coins.length][amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}