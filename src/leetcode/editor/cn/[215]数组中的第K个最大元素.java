package leetcode.editor.cn;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 数组中的第K个最大元素
 * 2024-06-10 17:18:40
 */
@SuppressWarnings("all")
class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return findKthLeasest(nums, 0, nums.length - 1, nums.length - k);
        }

        private int findKthLeasest(int[] nums, int begin, int end, int k) {
            int partition = partition(nums, begin, end);
            if (k < partition) {
                return findKthLeasest(nums, begin, partition - 1, k);
            } else if (k > partition) {
                return findKthLeasest(nums, partition + 1, end, k);
            } else {
                return nums[partition];
            }
        }

        private int partition(int[] nums, int left, int right) {
            int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
            swap(nums, idx, left);
            int pv = nums[left];
            int i = left + 1, j = right;
            while (i <= j) {
                while (i <= j && nums[i] < pv) i++;
                while (i <= j && nums[j] > pv) j--;
                if (i <= j) swap(nums, i++, j--);
            }
            swap(nums, left, j);
            return j;
        }

        private void swap(int[] nums, int i, int j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}