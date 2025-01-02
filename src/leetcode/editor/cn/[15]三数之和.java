package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 2024-08-17 15:32:07
 */
@SuppressWarnings("all")
class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            int length = nums.length;
            for (int k = 0; k < length - 2; k++) {
                if (nums[k] > 0) break;
                if (k > 0 && nums[k] == nums[k - 1]) continue;
                if (nums[k] + nums[length - 1] + nums[length - 2] < 0) continue;
                int i = k + 1, j = length - 1;
                while (i < j) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0) {
                        while (i < j && nums[j] == nums[--j]) ;
                    } else if (sum < 0) {
                        while (i < j && nums[i] == nums[++i]) ;
                    } else {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        while (i < j && nums[i] == nums[++i]) ;
                        while (i < j && nums[j] == nums[--j]) ;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}