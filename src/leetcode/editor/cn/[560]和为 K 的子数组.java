package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 和为 K 的子数组
 * @author: xu
 * @date: 2026-10-01 21:21:09
 */
@SuppressWarnings("all")
class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);

            int sum = 0;
            int ans = 0;
            for (int num : nums) {
                sum += num;
                ans += map.getOrDefault(sum - k, 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}