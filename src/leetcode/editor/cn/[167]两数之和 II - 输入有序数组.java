package leetcode.editor.cn;

/**
 * 两数之和 II - 输入有序数组
 * 2024-08-17 15:13:55
 */
@SuppressWarnings("all")
class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                if (numbers[i] + numbers[j] > target) {
                    j--;
                } else if (numbers[i] + numbers[j] < target) {
                    i++;
                } else {
                    break;
                }
            }
            return new int[]{i + 1, j + 1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}