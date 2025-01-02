package leetcode.editor.cn;

/**
 * 最长重复子数组
 * 2024-08-08 22:10:31
 */
@SuppressWarnings("all")
class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0) return 0;
            if (nums2 == null || nums2.length == 0) return 0;
            if (nums1.length < nums2.length) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = nums1;
            }
            int[] dp = new int[nums2.length + 1];
            int maxLen = 0;
            for (int i = 1; i < nums1.length + 1; i++) {
                for (int j = nums2.length; j > 0; j--) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[j] = dp[j - 1] + 1;
                        maxLen = Integer.max(maxLen, dp[j]);
                    } else {
                        dp[j] = 0;
                    }
                }
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}