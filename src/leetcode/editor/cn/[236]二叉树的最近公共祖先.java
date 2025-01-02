package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树的最近公共祖先
 * 2024-06-19 15:38:57
 */
class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private Map<Integer, TreeNode> map = new HashMap<>();
        private Set<Integer> visited = new HashSet<>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            saveParentNode(root);
            while (p != null) {
                visited.add(p.val);
                p = map.get(p.val);
            }
            while (q != null) {
                if (visited.contains(q.val)) {
                    return q;
                }
                q = map.get(q.val);
            }
            return null;
        }

        private void saveParentNode(TreeNode node) {
            if (node.left != null) {
                map.put(node.left.val, node);
                saveParentNode(node.left);
            }
            if (node.right != null) {
                map.put(node.right.val, node);
                saveParentNode(node.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}