package leetcode.editor.cn;

/**
 * 设计循环队列
 * 2024-06-01 14:40:19
 */
class DesignCircularQueue {
    public static void main(String[] args) {
        //MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        //circularQueue.enQueue(1); // 返回 true
        //circularQueue.enQueue(2); // 返回 true
        //circularQueue.enQueue(3); // 返回 true
        //circularQueue.enQueue(4); // 返回 false，队列已满
        //System.out.println(circularQueue.Rear()); // 返回 3
        //circularQueue.isFull(); // 返回 true
        //circularQueue.deQueue(); // 返回 true
        //circularQueue.enQueue(4); // 返回 true
        //System.out.println(circularQueue.Rear()); // 返回 4
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {
        int[] array;
        int head, tail;

        public MyCircularQueue(int k) {
            array = new int[k + 1];
            head = tail = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            array[tail] = value;
            tail = (tail + 1) % array.length;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            head = (head + 1) % array.length;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return array[head];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            return array[(tail - 1 + array.length) % array.length];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return head == ((tail + 1) % array.length);
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}