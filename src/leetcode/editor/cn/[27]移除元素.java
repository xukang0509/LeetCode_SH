package leetcode.editor.cn;

/**
 * @Description: 移除元素
 * @author: xu
 * @date: 2026-09-27 19:57:57
 */
@SuppressWarnings("all")
class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                if (nums[left] == val) {
                    nums[left] = nums[right--];
                } else {
                    left++;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}