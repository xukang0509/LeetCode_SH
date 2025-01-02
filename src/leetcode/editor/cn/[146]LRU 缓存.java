package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LRU 缓存
 * 2024-08-25 19:16:59
 */
@SuppressWarnings("all")
class LruCache {
    public static void main(String[] args) {
        //LRUCache lRUCache = new LRUCache(2);
        //lRUCache.put(1, 1); // 缓存是 {1=1}
        //lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        //lRUCache.get(1); // 返回 1
        //lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        //lRUCache.get(2); // 返回 -1 (未找到)
        //lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        //lRUCache.get(1); // 返回 -1 (未找到)
        //lRUCache.get(3); // 返回 3 lRUCache.get(4); // 返回 4
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private final LinkedList<Node> list = new LinkedList<>();
        private final Map<Integer, Node> map = new HashMap<>();
        private final int capacity;

        LRUCache(int capacity) {
            this.capacity = capacity;
        }

        int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                list.remove(node);
                list.addFirst(node);
                return;
            }
            node = new Node(key, value);
            map.put(key, node);
            list.addFirst(node);
            if (list.size() > capacity) {
                Node last = list.removeLast();
                map.remove(last.key);
            }
        }


        private static class Node {
            int key;
            int value;

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