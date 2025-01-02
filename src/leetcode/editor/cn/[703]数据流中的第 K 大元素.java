package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 数据流中的第 K 大元素
 * 2024-06-10 17:28:44
 */
class KthLargestElementInAStream {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        private PriorityQueue<Integer> heap;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (heap.size() < k) {
                heap.offer(val);
            } else if (val > heap.peek()) {
                heap.offer(val);
                heap.poll();
            }
            return heap.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}