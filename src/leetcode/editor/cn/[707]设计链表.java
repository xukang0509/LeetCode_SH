package leetcode.editor.cn;

/**
 * @Description: 设计链表
 * @author: xu
 * @date: 2026-10-01 17:04:06
 */
@SuppressWarnings("all")
class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new DesignLinkedList().new MyLinkedList();
        myLinkedList.addAtHead(0);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtTail(5);
        myLinkedList.addAtIndex(2, 3);
        myLinkedList.get(1);
        myLinkedList.get(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtIndex(2, 3);
        myLinkedList.addAtTail(5);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {
        private Node head;
        private Node tail;
        private int size = 0;

        public MyLinkedList() {
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            return node(index).val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) return;
            Node node = node(index);
            Node prev = node.prev;
            Node newNode = new Node(prev, val, node);
            prev.next = node.prev = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            Node node = node(index);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = node.prev = null;
            size--;
        }

        private Node node(int index) {
            if ((size >>> 1) <= index) {
                Node cur = tail;
                for (int i = 0; i < size - index; i++) {
                    cur = cur.prev;
                }
                return cur;
            } else {
                Node cur = head;
                for (int i = 0; i <= index; i++) {
                    cur = cur.next;
                }
                return cur;
            }
        }

        private class Node {
            int val;
            Node prev;
            Node next;

            public Node() {
            }

            public Node(int val) {
                this.val = val;
            }

            public Node(Node prev, int val, Node next) {
                this.val = val;
                this.prev = prev;
                this.next = next;
            }
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}