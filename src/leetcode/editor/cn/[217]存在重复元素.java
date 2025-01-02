package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * 2024-07-15 14:37:41
 */
class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>(nums.length << 1);
            for (int num : nums) {
                if (!set.add(num)) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}