package leetcode.editor.cn;

/**
 * 颜色分类
 * 2024-07-20 10:13:35
 */
@SuppressWarnings("all")
class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            if (nums.length <= 1) return;
            int p0 = 0, p2 = nums.length - 1;
            for (int i = 0; i <= p2; i++) {
                while (i <= p2 && nums[i] == 2) swap(nums, i, p2--);
                if (nums[i] == 0) {
                    swap(nums, i, p0++);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}