package leetcode.editor.cn;

/**
 * 最大间距
 * 2024-07-18 17:19:06
 */
@SuppressWarnings("all")
class MaximumGap {
    public static void main(String[] args) {
        Solution solution = new MaximumGap().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumGap(int[] nums) {
            // 特殊情况处理
            if (nums.length < 2) return 0;
            // 找最大最小值
            int max = nums[0];
            int min = nums[0];
            for (int num : nums) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            if (max == min) return 0;
            // 桶
            int range = Math.max((max - min) / nums.length, 1);
            int size = (max - min) / range + 1;
            Pair[] buckets = new Pair[size];
            // 放入数据
            for (int num : nums) {
                int idx = (num - min) / range;
                if (buckets[idx] == null) {
                    buckets[idx] = new Pair();
                }
                buckets[idx].add(num);
            }
            // 寻找最大差值
            int maxD = 0;
            int lastMax = buckets[0].max;
            for (int i = 1; i < buckets.length; i++) {
                Pair pair = buckets[i];
                if (pair != null) {
                    maxD = Math.max(maxD, pair.min - lastMax);
                    lastMax = pair.max;
                }
            }
            return maxD;
        }

        private static class Pair {
            int max = 0;
            int min = 1000_000_000;

            public void add(int n) {
                max = Math.max(max, n);
                min = Math.min(min, n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}