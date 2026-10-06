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
        System.out.println(solution.fourSum(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            int length = nums.length;
            if (length < 4) return result;
            Arrays.sort(nums);
            for (int one = 0; one < length - 3; one++) {
                if ((nums[one] > target && nums[one] >= 0) || (long) nums[one] + nums[one + 1] + nums[one + 2] + nums[one + 3] > target)
                    break;
                if (one > 0 && nums[one] == nums[one - 1]) continue;
                if ((long) nums[one] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) continue;
                for (int two = one + 1; two < length - 2; two++) {
                    int onePlusTwo = nums[one] + nums[two];
                    if ((onePlusTwo > target && onePlusTwo >= 0) ||
                            (long) onePlusTwo + nums[two + 1] + nums[two + 2] > target)
                        break;
                    if (two > one + 1 && nums[two] == nums[two - 1]) continue;
                    if ((long) onePlusTwo + nums[length - 1] + nums[length - 2] < target) continue;

                    int l = two + 1, r = length - 1;
                    while (l < r) {
                        long sum = (long) onePlusTwo + nums[l] + nums[r];
                        if (sum > target) r--;
                        else if (sum < target) l++;
                        else {
                            result.add(Arrays.asList(nums[one], nums[two], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[++l]) ;
                            while (l < r && nums[r] == nums[--r]) ;
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}