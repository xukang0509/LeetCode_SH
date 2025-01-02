package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 2024-08-17 15:32:29
 */
@SuppressWarnings("all")
class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        System.out.println(solution.fourSum(new int[]{0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000}, -1000000000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            int length = nums.length;
            if (nums == null || length < 4) return result;
            Arrays.sort(nums); // 数组进行升序排序
            for (int one = 0; one < length - 3; one++) {
                if (one > 0 && nums[one] == nums[one - 1]) continue;
                if ((long) nums[one] + nums[one + 1] + nums[one + 2] + nums[one + 3] > target) break;
                if ((long) nums[one] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) continue;
                for (int two = one + 1; two < length - 2; two++) {
                    if (two > one + 1 && nums[two] == nums[two - 1]) continue;
                    if ((long) nums[one] + nums[two] + nums[two + 1] + nums[two + 2] > target) break;
                    if ((long) nums[one] + nums[two] + nums[length - 1] + nums[length - 2] < target) continue;
                    int left = two + 1, right = length - 1;
                    while (left < right) {
                        long sum = (long) nums[left] + nums[right] + nums[two] + nums[one];
                        if (sum > target) {
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            result.add(Arrays.asList(nums[one], nums[two], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[++left]) ;
                            while (left < right && nums[right] == nums[--right]) ;
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}