package leetcode.editor.cn;

/**
 * @Description: 删除有序数组中的重复项
 * @author: xu
 * @date: 2026-09-27 20:37:25
 */
@SuppressWarnings("all")
class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 1;
            for (int fast = 1; fast < nums.length; fast++) {
                if (nums[fast] != nums[fast - 1]) {
                    nums[slow++] = nums[fast];
                }
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}