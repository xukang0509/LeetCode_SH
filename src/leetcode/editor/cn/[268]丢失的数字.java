package leetcode.editor.cn;

/**
 * @Description: 丢失的数字
 * @author: xu
 * @date: 2026-10-05 14:36:33
 */
@SuppressWarnings("all")
class MissingNumber {
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res ^= i;
                res ^= nums[i];
            }
            res ^= nums.length;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}