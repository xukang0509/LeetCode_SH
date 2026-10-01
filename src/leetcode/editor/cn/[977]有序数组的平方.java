package leetcode.editor.cn;

/**
 * @Description: 有序数组的平方
 * @author: xu
 * @date: 2026-09-29 18:55:29
 */
@SuppressWarnings("all")
class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
        // TO TEST
        solution.sortedSquares(new int[]{-5, -3, -2, -1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] result = new int[nums.length];
            int left = 0, right = nums.length - 1, index = nums.length - 1;
            while (left <= right) {
                result[index--] = Math.abs(nums[left]) >= Math.abs(nums[right]) ? nums[left] * nums[left++] : nums[right] * nums[right--];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}