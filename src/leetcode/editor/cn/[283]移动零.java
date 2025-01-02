package leetcode.editor.cn;

/**
 * 移动零
 * 2024-08-17 15:05:55
 */
@SuppressWarnings("all")
class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0, j = 0;
            while (j < nums.length) {
                if (nums[j] != 0) {
                    swap(nums, i, j);
                    i++;
                }
                j++;
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j) return;
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}