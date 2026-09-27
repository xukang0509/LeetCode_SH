package leetcode.editor.cn;

/**
 * 移动零
 * 2024-08-17 15:05:55
 */
@SuppressWarnings("all")
class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        solution.moveZeroes(new int[]{1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            for (int fast = 0, slow = 0; fast < nums.length; fast++) {
                if (nums[fast] != 0) {
                    swap(nums, fast, slow++);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j) return;
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}