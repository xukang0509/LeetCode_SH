package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author xk
 * @date 2026-09-25 21:09:14
 */
@SuppressWarnings("all")
class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
        int[] ints = solution.searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >>> 1);
                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left == nums.length || nums[left] != target) {
                return new int[]{-1, -1};
            }
            right = left;
            while (right < nums.length && nums[right] == target) {
                right = right + 1;
            }
            return new int[]{left, right - 1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}