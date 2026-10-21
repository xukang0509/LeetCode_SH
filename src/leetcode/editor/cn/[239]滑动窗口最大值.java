package leetcode.editor.cn;

/**
 * 滑动窗口最大值
 * 2024-08-20 09:27:55
 */
@SuppressWarnings("all")
class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int length = nums.length;
            int[] prefix = new int[length];
            int[] suffix = new int[length];
            for (int i = 0; i < length; i++) {
                if (i % k == 0) {
                    prefix[i] = nums[i];
                } else {
                    prefix[i] = Math.max(nums[i], prefix[i - 1]);
                }
            }
            for (int i = length - 1; i >= 0; i--) {
                if ((i + 1) % k == 0 || i == length - 1) {
                    suffix[i] = nums[i];
                } else {
                    suffix[i] = Math.max(nums[i], suffix[i + 1]);
                }
            }
            int[] res = new int[length - k + 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = Math.max(prefix[i + k - 1], suffix[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}