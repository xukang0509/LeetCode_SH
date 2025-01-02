package leetcode.editor.cn;

/**
 * 只出现一次的数字
 * 2024-07-15 14:41:17
 */
class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int num = nums[0];
            for (int i = 1; i < nums.length; i++) {
                num ^= nums[i];
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}