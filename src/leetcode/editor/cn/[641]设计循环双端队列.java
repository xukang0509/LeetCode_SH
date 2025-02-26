package leetcode.editor.cn;

/**
 * 设计循环双端队列
 * 2024-06-04 10:35:56
 */
class DesignCircularDeque {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularDeque {
        private int[] array;
        private int head;
        private int tail;

        public MyCircularDeque(int k) {
            array = new int[k + 1];
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;
            head = (head - 1 + array.length) % array.length;
            array[head] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;
            array[tail] = value;
            tail = (tail + 1) % array.length;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;
            head = (head + 1) % array.length;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            tail = (tail - 1 + array.length) % array.length;
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            return array[head];
        }

        public int getRear() {
            if (isEmpty()) return -1;
            return array[(tail - 1 + array.length) % array.length];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return head == (tail + 1) % array.length;
        }
    }

    class MyCircularDeque1 {
        private Node sentinel = new Node(null, Integer.MIN_VALUE, null);
        private int capacity;
        private int size;

        public MyCircularDeque1(int k) {
            this.capacity = k;
            sentinel.next = sentinel.prev = sentinel;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;
            Node added = new Node(sentinel, value, sentinel.next);
            sentinel.next = added;
            added.next.prev = added;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;
            Node added = new Node(sentinel.prev, value, sentinel);
            sentinel.prev = added;
            added.prev.next = added;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;
            Node delNode = sentinel.next;
            sentinel.next = delNode.next;
            delNode.next.prev = sentinel;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            Node delNode = sentinel.prev;
            sentinel.prev = delNode.prev;
            delNode.prev.next = sentinel;
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            return sentinel.next.val;
        }

        public int getRear() {
            if (isEmpty()) return -1;
            return sentinel.prev.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        private static class Node {
            Node prev;
            int val;
            Node next;

            public Node(Node prev, int val, Node next) {
                this.prev = prev;
                this.val = val;
                this.next = next;
            }
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}