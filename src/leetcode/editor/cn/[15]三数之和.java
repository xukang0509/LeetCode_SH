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
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            int length = nums.length;
            // nums[i]: a，nums[left]：b，nums[right]：c
            for (int i = 0; i < length - 2; i++) {
                if (nums[i] > 0 || nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
                // 剪枝：a去重，对已经处理过的数字进行去重
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                // 剪枝：最低的数字 和 最大的两个数字 相加小于0时，continue
                if (nums[i] + nums[length - 1] + nums[length - 2] < 0) continue;

                int left = i + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum > 0) right--;
                    else if (sum < 0) left++;
                    else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while (left < right && nums[right] == nums[--right]) ;
                        while (left < right && nums[left] == nums[++left]) ;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}