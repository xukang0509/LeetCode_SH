package leetcode.editor.cn;

/**
 * 打家劫舍
 * 2024-08-13 09:45:29
 */
@SuppressWarnings("all")
class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Integer.max(nums[1], dp[0]);
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Integer.max(dp[i - 1], nums[i] + dp[i - 2]);
            }
            return dp[dp.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}