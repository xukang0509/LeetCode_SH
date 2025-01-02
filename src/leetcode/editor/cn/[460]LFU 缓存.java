package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * LFU 缓存
 * 2024-08-25 19:17:15
 */
@SuppressWarnings("all")
class LfuCache {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        // key：data，value：节点
        private final Map<Integer, Node> kvMap = new HashMap<>();
        // key：访问频数，value：该访问频数下的数据集合，头为最近访问的数据
        private final Map<Integer, DoublyLinkedList> frepMap = new HashMap<>();
        private final int capacity;
        private int minFrep;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = kvMap.get(key);
            if (node == null) return -1;
            DoublyLinkedList oldList = frepMap.get(node.frep);
            oldList.remove(node);
            if (node.frep == minFrep && oldList.isEmpty()) {
                minFrep++;
            }
            node.frep++;
            DoublyLinkedList newList = frepMap.computeIfAbsent(node.frep, k -> new DoublyLinkedList());
            newList.addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (kvMap.containsKey(key)) {
                Node node = kvMap.get(key);
                DoublyLinkedList list = frepMap.get(node.frep);
                list.remove(node);
                if (node.frep == minFrep && list.isEmpty()) {
                    minFrep++;
                }
                node.value = value;
                node.frep++;
                frepMap.computeIfAbsent(node.frep, k -> new DoublyLinkedList()).addFirst(node);
            } else {
                if (kvMap.size() == capacity) {
                    DoublyLinkedList list = frepMap.get(minFrep);
                    Node last = list.removeLast();
                    kvMap.remove(last.key);
                }
                Node node = new Node(key, value, 1);
                kvMap.put(key, node);
                minFrep = 1;
                frepMap.computeIfAbsent(node.frep, k -> new DoublyLinkedList()).addFirst(node);
            }
        }

        private static class DoublyLinkedList {
            private final Node head;
            private final Node tail;
            private int size = 0;

            DoublyLinkedList() {
                head = tail = new Node();
                head.next = tail;
                tail.prev = head;
            }

            void addFirst(Node newFirst) {
                Node oldFirst = head.next;
                head.next = newFirst;
                oldFirst.prev = newFirst;
                newFirst.prev = head;
                newFirst.next = oldFirst;
                size++;
            }

            void remove(Node node) {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
                node.prev = node.next = null;
                size--;
            }

            Node removeLast() {
                Node last = tail.prev;
                remove(last);
                return last;
            }

            boolean isEmpty() {
                return size == 0;
            }
        }

        private static class Node {
            Node prev;
            Node next;
            int key;
            int value;
            int frep;

            public Node() {
            }

            public Node(int key, int value, int frep) {
                this.key = key;
                this.value = value;
                this.frep = frep;
            }
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}