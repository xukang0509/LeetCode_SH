package leetcode.editor.cn;

/**
 * 二分查找
 *
 * @author xk
 * @date 2026-09-25 20:54:15
 */
@SuppressWarnings("all")
class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + ((right - left) >>> 1);
                if (nums[mid] > target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}