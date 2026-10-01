package leetcode.editor.cn;

/**
 * @Description: 长度最小的子数组
 * @author: xu
 * @date: 2026-09-29 20:42:53
 */
@SuppressWarnings("all")
class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        // TO TEST
        solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int result = Integer.MAX_VALUE;
            int sum = 0;
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                while (sum >= target) {
                    result = Math.min(result, j - i + 1);
                    sum -= nums[i++];
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}