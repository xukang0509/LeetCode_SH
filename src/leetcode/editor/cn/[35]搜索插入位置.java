package leetcode.editor.cn;

/**
 * 搜索插入位置
 *
 * @author xk
 * @date 2026-09-25 21:04:27
 */
@SuppressWarnings("all")
class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >>> 1);
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}