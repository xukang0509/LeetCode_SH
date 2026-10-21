package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
            map.forEach((num, count) -> {
                priorityQueue.offer(new int[]{count, num});
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            });

            int[] res = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                res[i] = priorityQueue.poll()[1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}