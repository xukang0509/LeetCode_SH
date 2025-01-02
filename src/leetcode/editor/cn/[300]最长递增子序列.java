package leetcode.editor.cn;

/**
 * 最长递增子序列
 * 2024-08-08 22:11:32
 */
@SuppressWarnings("all")
class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            // 牌顶数组
            int[] top = new int[nums.length];
            // 牌堆的数量
            int len = 0;
            // 遍历所有的牌
            for (int num : nums) {
                int begin = 0, end = len;
                while (begin < end) {
                    int mid = (begin + end) >>> 1;
                    if (num <= top[mid]) {
                        end = mid;
                    } else {
                        begin = mid + 1;
                    }
                }
                // 覆盖牌顶
                top[begin] = num;
                // 检查是否要新建一个牌堆
                if (begin == len) len++;
            }
            return len;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}