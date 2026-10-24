package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历
 * 2024-06-13 15:03:03
 */
@SuppressWarnings("ALL")
class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        // 后序：左右根  前序：根左右 -> 根右左 -> (反转)左右根
        /*
                 5
                /  \
               4    6
              / \
             1   2
         */
        // 后序  1 2 4 6 5
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            TreeNode curr = root;
            while (curr != null) {
                if (curr.left != null) {
                    TreeNode rightMost = curr.left;
                    while (rightMost.right != null && rightMost.right != curr) {
                        rightMost = rightMost.right;
                    }
                    if (rightMost.right == null) {
                        rightMost.right = curr;
                        curr = curr.left;
                    } else {
                        rightMost.right = null;
                        processReverse(curr.left, result);
                        curr = curr.right;
                    }
                } else {
                    curr = curr.right;
                }
            }
            processReverse(root, result);
            return result;
        }

        private void processReverse(TreeNode node, List<Integer> result) {
            if (node == null) return;
            node = reverseList(node);
            TreeNode p = node;
            while (p != null) {
                result.add(p.val);
                p = p.right;
            }
            reverseList(node);
        }

        private TreeNode reverseList(TreeNode node) {
            if (node.right == null) return node;
            TreeNode head = null, p = node, temp = null;
            while (p != null) {
                temp = p.right;
                p.right = head;
                head = p;
                p = temp;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     当前节点 curr 指向根节点 curr = root，处理curr直到curr==null
     1.curr无左孩子，curr = curr.right;
     2.curr有左孩子，找到左子树的最右节点mostRight，即中序遍历中curr的上一节点
     2.1.如果mostRight的右孩子指向null，则 mostRight.right = curr; curr = curr.left;
     2.1.如果mostRight的右孩子指向curr，则 mostRight.right = null; curr = curr.right;
     */
}