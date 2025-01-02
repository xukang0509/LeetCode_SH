package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 * 2024-06-10 17:40:45
 */
class FindMedianFromDataStream {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        // 大顶堆
        private PriorityQueue<Integer> left;
        // 小顶堆
        private PriorityQueue<Integer> right;

        public MedianFinder() {
            left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            right = new PriorityQueue<>((a, b) -> Integer.compare(a, b)); // 默认为小顶堆
        }

        /**
         * 为了保证两端数据量的平衡
         * <ul>
         * <li>两边数据一样时，加入左边</li>
         * <li>两边数据不一样时，加入右边</li>
         * </ul>
         * 但是，随便一个数能直接加入吗？
         * <ul>
         * <li>加入左边前，应该挑右边最小的加入</li>
         * <li>加入右边前，应该挑左边最大的加入</li>
         * </ul>
         */
        public void addNum(int num) {
            if (left.size() == right.size()) {
                right.offer(num);
                left.offer(right.poll());
            } else {
                left.offer(num);
                right.offer(left.poll());
            }
        }

        public double findMedian() {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) / 2.0;
            }
            return left.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}