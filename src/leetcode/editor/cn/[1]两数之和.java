package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 2024-05-13 15:42:16
 */
class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            throw new RuntimeException();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}