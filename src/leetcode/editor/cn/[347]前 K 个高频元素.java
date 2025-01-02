package leetcode.editor.cn;

/**
 * 前 K 个高频元素
 * 2024-07-19 11:49:53
 */
@SuppressWarnings("all")
class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();

    }

    // [1,1,1,2,2,3]
    // [0,3,2,1]
    // [1,2]
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // TODO
        public int[] topKFrequent(int[] nums, int k) {
            int[] res = new int[k];
            int max = nums[0], min = nums[0];
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }
            int[] counting = new int[max - min + 1];
            for (int num : nums) {
                counting[num - min]++;
            }


            for (int i = 0; i < k; i++) {
                //int idx = findKMax(counting, 0, counting.length - 1, i + 1);
                //res[i] = idx + min;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}