package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * 2024-08-20 09:27:55
 */
@SuppressWarnings("all")
class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
                int num = nums[j];
                if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                    deque.pollFirst();
                }
                while (!deque.isEmpty() && deque.peekLast() < num) {
                    deque.pollLast();
                }
                deque.offerLast(num);
                if (i >= 0) {
                    res[i] = deque.peekFirst();
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}