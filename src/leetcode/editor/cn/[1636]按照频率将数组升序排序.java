package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 按照频率将数组升序排序
 * 2024-07-17 14:02:28
 */
class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        Solution solution = new SortArrayByIncreasingFrequency().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] frequencySort(int[] nums) {
            int[] counting = new int[201];
            for (int num : nums) {
                counting[num + 100]++;
            }
            return Arrays.stream(nums).boxed().sorted((a, b) -> {
                int fa = counting[a + 100];
                int fb = counting[b + 100];
                return fa == fb ? Integer.compare(b, a) : fa - fb;
            }).mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}