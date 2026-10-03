package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 四数相加 II
 * @author: xu
 * @date: 2026-10-03 12:27:23
 */
@SuppressWarnings("all")
class FourSumIi {
    public static void main(String[] args) {
        Solution solution = new FourSumIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            for (int i : nums1) {
                for (int j : nums2) {
                    map.put(i + j, map.getOrDefault(i + j, 0) + 1);
                }
            }
            for (int u : nums3) {
                for (int v : nums4) {
                    res += map.getOrDefault(-u - v, 0);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}