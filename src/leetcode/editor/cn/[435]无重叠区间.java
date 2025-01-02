package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 无重叠区间
 * 2024-08-05 20:12:14
 */
@SuppressWarnings("all")
class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) return 0;
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
            int i = 0, j;
            int count = 1;
            for (j = 1; j < intervals.length; j++) {
                if (intervals[j][0] >= intervals[i][1]) {
                    i = j;
                    count++;
                }
            }
            return intervals.length - count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}