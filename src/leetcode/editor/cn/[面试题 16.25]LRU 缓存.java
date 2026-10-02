package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: LRU 缓存
 * @author: xu
 * @date: 2026-10-01 19:43:07
 */
@SuppressWarnings("all")
class LruCacheLcci {
    public static void main(String[] args) {
        LruCacheLcci.LRUCache cache = new LruCacheLcci().new LRUCache(2);
        // TO TEST
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("cache.get(1) = " + cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println("cache.get(2) = " + cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println("cache.get(1) = " + cache.get(1));       // 返回 -1 (未找到)
        System.out.println("cache.get(3) = " + cache.get(3));       // 返回  3
        System.out.println("cache.get(4) = " + cache.get(4));       // 返回  4
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private final Map<Integer, Node> map;
        private final Node head = new Node();
        private final Node tail = new Node();
        private final int capacity;

        public LRUCache(int capacity) {
            this.map = new HashMap();
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = this.map.get(key);
            if (node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = this.map.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
                return;
            }
            node = new Node(key, value);
            this.map.put(key, node);
            addToHead(node);
            if (map.size() > capacity) {
                Node removed = remove();
                this.map.remove(removed.key);
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = node.prev = null;
        }

        private Node remove() {
            Node node = tail.prev;
            removeNode(node);
            return node;
        }

        private static class Node {
            Node prev;
            int key;
            int value;
            Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}