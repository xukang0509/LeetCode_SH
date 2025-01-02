package leetcode.editor.cn;

/**
 * 零钱兑换
 * 2024-08-04 14:27:32
 */
@SuppressWarnings("all")
class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 5, 2, 10}, 22));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            for (int j = 1; j < amount + 1; j++) {
                dp[j] = amount + 1;
            }
            for (int coin : coins) {
                for (int j = coin; j < amount + 1; j++) {
                    dp[j] = Integer.min(dp[j], dp[j - coin] + 1);
                }
            }
            int res = dp[amount];
            return res > amount ? -1 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}