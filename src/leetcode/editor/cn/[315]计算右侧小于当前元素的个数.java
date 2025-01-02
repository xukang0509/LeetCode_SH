package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

/**
 * 计算右侧小于当前元素的个数
 * 2024-07-19 10:57:25
 */
@SuppressWarnings("all")
class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
        System.out.println(solution.countSmaller(new int[]{1, 9, 7, 8, 5}));
        // 1 9    5 7 8
        // 0 0    1 1 0
        // 0 3    1 1 0
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // TODO: 树状数组、线段树
        public List<Integer> countSmaller(int[] nums) {
            int[] res = countSmaller(nums, 0, nums.length, new int[nums.length]);
            return Arrays.stream(res).boxed().toList();
        }

        private int[] countSmaller(int[] nums, int begin, int end, int[] res) {
            if (end - begin < 2) return res;
            int mid = (begin + end) >>> 1;
            countSmaller(nums, begin, mid, res);
            countSmaller(nums, mid, end, res);
            merge(nums, begin, mid, end, res);
            return res;
        }

        private void merge(int[] nums, int begin, int mid, int end, int[] res) {
            int[] temp = Arrays.copyOfRange(nums, begin, mid);
            int ls = 0, le = mid - begin;
            int rs = mid, re = end;
            int k = begin;
            while (ls < le) {
                if (rs < re && temp[ls] > nums[rs]) {

                    nums[k++] = nums[rs++];
                } else {
                    nums[k++] = temp[ls++];
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}