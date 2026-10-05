package leetcode.editor.cn;

/**
 * @Description: 寻找重复数
 * @author: xu
 * @date: 2026-10-05 15:22:33
 */
@SuppressWarnings("all")
class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            int fast = 0, slow = 0;
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (fast != slow);
            slow = 0;
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return fast;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}