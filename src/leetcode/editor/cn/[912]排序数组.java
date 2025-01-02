package leetcode.editor.cn;

/**
 * 排序数组
 * 2024-07-19 09:26:25
 */
@SuppressWarnings("all")
class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            countingSort(nums);
            return nums;
        }

        private void countingSort(int[] array) {
            // 找出最大最小值
            int min = array[0];
            int max = array[0];
            for (int num : array) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            // 开辟内存空间，存储次数
            int[] counts = new int[max - min + 1];
            // 统计每个整数出现的次数
            for (int num : array) {
                counts[num - min]++;
            }
            // 根据整数的出现次数，对整数进行排序
            int index = 0;
            for (int i = 0; i < counts.length; i++) {
                // (i + min) 代表原始数组元素，counts[i] 代表元素出现个数
                while (counts[i] > 0) {
                    array[index++] = i + min;
                    counts[i]--;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}