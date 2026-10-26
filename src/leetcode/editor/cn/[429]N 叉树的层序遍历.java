package leetcode.editor.cn;

import leetcode.editor.util.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: N 叉树的层序遍历
 * @author: xu
 * @date: 2026-10-24 12:16:16
 */
@SuppressWarnings("all")
class NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> nums = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    Node poll = queue.poll();
                    nums.add(poll.val);
                    for (Node child : poll.children) {
                        queue.offer(child);
                    }
                }
                result.add(nums);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}