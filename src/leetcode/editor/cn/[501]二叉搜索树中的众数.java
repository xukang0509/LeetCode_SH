package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 501 二叉搜索树中的众数 find-mode-in-binary-search-tree
 * @author: xu
 * @date: 2026-11-02 12:53:18
 */
@SuppressWarnings("all")
class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
        // TO TEST
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        private int c, maxC;
        private List<Integer> modes;
        TreeNode prev = null;

        public int[] findMode(TreeNode root) {
            c = 0;
            maxC = 0;
            modes = new ArrayList<>();
            TreeNode curr = root;
            while (curr != null) {
                if (curr.left != null) {
                    TreeNode rightMost = curr.left;
                    while (rightMost.right != null && rightMost.right != curr) {
                        rightMost = rightMost.right;
                    }
                    if (rightMost.right == curr) {
                        // 中
                        update(curr.val);
                        prev = curr;
                        rightMost.right = null;
                        curr = curr.right;
                    } else {
                        rightMost.right = curr;
                        curr = curr.left;
                    }
                } else {
                    // 中
                    update(curr.val);
                    prev = curr;
                    curr = curr.right;
                }
            }
            int[] res = new int[modes.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = modes.get(i);
            }
            return res;
        }

        private void update(int nodeVal) {
            if (prev == null || prev.val != nodeVal) {
                c = 1;
            } else {
                c++;
            }
            if (c > maxC) {
                modes.clear();
                modes.add(nodeVal);
                maxC = c;
            } else if (c == maxC) {
                modes.add(nodeVal);
            }
        }


        // ====================================================================================================================================
        private List<Integer> result;
        private int count;
        private int maxCount;
        private TreeNode pre;

        public int[] findMode2(TreeNode root) {
            result = new ArrayList<>();
            count = 0;
            maxCount = 0;
            pre = null;
            dfs(root);
            int[] res = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }
            return res;
        }

        private void dfs(TreeNode node) {
            if (node == null) return;
            dfs(node.left);
            if (pre == null || pre.val != node.val) {
                count = 1;
            } else {
                count++;
            }
            if (count > maxCount) {
                result.clear();
                result.add(node.val);
                maxCount = count;
            } else if (count == maxCount) {
                result.add(node.val);
            }
            pre = node;
            dfs(node.right);
        }

        // ========================================================================================
        public int[] findMode1(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            int cnt = 0, maxCnt = 0;

            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode curr = root, prev = null;
            while (!stack.isEmpty() || curr != null) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    // 计数
                    if (prev == null || prev.val != curr.val) {
                        cnt = 1;
                    } else {
                        cnt++;
                    }
                    // 更新结果以及maxCnt
                    if (cnt > maxCnt) {
                        res.clear();
                        res.add(curr.val);
                        maxCnt = cnt;
                    } else if (cnt == maxCnt) {
                        res.add(curr.val);
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
            int[] r = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                r[i] = res.get(i);
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}