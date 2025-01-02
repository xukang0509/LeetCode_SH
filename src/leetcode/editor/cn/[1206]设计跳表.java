package leetcode.editor.cn;

/**
 * 设计跳表
 * 2024-08-25 20:28:11
 */
@SuppressWarnings("all")
class DesignSkiplist {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Skiplist {
        private static final int MAX_LEVEL = 32;
        private static final double P = 0.25;

        private final Node first;
        private int level;

        public Skiplist() {
            first = new Node(-1, MAX_LEVEL);
        }

        public boolean search(int target) {
            Node node = first;
            for (int i = level - 1; i >= 0; i--) {
                int cmp = -1;
                while (node.nexts[i] != null && (cmp = target - node.nexts[i].value) > 0) {
                    node = node.nexts[i];
                }
                if (cmp == 0) return true;
            }
            return false;
        }

        public void add(int num) {
            Node node = first;
            Node[] prevs = new Node[level];
            for (int i = level - 1; i >= 0; i--) {
                while (node.nexts[i] != null && (num - node.nexts[i].value) >= 0) {
                    node = node.nexts[i];
                }
                prevs[i] = node;
            }
            int newLevel = randomLevel();
            Node newNode = new Node(num, newLevel);
            for (int i = 0; i < newLevel; i++) {
                if (i < level) {
                    newNode.nexts[i] = prevs[i].nexts[i];
                    prevs[i].nexts[i] = newNode;
                } else {
                    first.nexts[i] = newNode;
                }
            }
            level = Math.max(level, newLevel);
        }

        public boolean erase(int num) {
            Node node = first;
            Node[] prevs = new Node[level];
            boolean exist = false;
            for (int i = level - 1; i >= 0; i--) {
                int cmp = -1;
                while (node.nexts[i] != null && (cmp = num - node.nexts[i].value) > 0) {
                    node = node.nexts[i];
                }
                if (cmp == 0) exist = true;
                prevs[i] = node;
            }
            if (!exist) return false;
            Node removedNode = node.nexts[0];
            for (int i = 0; i < removedNode.nexts.length; i++) {
                prevs[i].nexts[i] = removedNode.nexts[i];
                removedNode.nexts[i] = null;
            }
            int newLevel = level;
            while (--newLevel > 0 && first.nexts[newLevel] == null) {
                level = newLevel;
            }
            return true;
        }

        private int randomLevel() {
            int level = 1;
            while (Math.random() < P && level < MAX_LEVEL) {
                level++;
            }
            return level;
        }

        private static class Node {
            int value;
            Node[] nexts;

            public Node(int value, int length) {
                this.value = value;
                nexts = new Node[length];
            }
        }
    }

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
//leetcode submit region end(Prohibit modification and deletion)

}