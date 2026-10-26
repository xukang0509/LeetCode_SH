package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 559 N 叉树的最大深度 maximum-depth-of-n-ary-tree
 * @author: xu
 * @date: 2026-10-26 12:11:11
 */
@SuppressWarnings("all")
class MaximumDepthOfNAryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfNAryTree().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public int maxDepth(Node root) {
            if (root == null) return 0;
            int maxD = 0;
            Deque<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                maxD++;
                for (int i = 0; i < size; i++) {
                    Node poll = queue.poll();
                    if (poll.children != null && !poll.children.isEmpty()) {
                        for (Node child : poll.children) {
                            queue.offer(child);
                        }
                    }
                }
            }
            return maxD;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}