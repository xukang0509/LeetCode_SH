package leetcode.editor.util;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 通用的树的前中后遍历
 * @author: xu
 * @date: 2026/10/23 20:59
 */
@SuppressWarnings("ALL")
public class CommonTreeTraversal {
    public static void main(String[] args) {
         /*
                1
               / \
              2   3
             /   / \
            4   5   6
         */
        // 前 1 2 4 3 5 6
        // 中 4 2 1 5 3 6
        // 后 4 2 5 6 3 1
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(5), new TreeNode(6))
        );

        commonTreeTraversal(root);
    }


    public static void commonTreeTraversal(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root; // 当前节点
        TreeNode prevNode = null; // 上一个处理的节点

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                //colorPrintln("前：" + curr.val, 31);
                pre.add(curr.val);
                // 待处理左子树
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) { // 没有右子树
                    //colorPrintln("中：" + peek.val, 36);
                    //colorPrintln("后：" + peek.val, 34);
                    in.add(peek.val);
                    post.add(peek.val);
                    prevNode = stack.pop();
                } else if (peek.right == prevNode) { // 右子树处理完成
                    //colorPrintln("后：" + peek.val, 34);
                    post.add(peek.val);
                    prevNode = stack.pop();
                } else { // 待处理右子树
                    //colorPrintln("中：" + peek.val, 36);
                    in.add(peek.val);
                    curr = peek.right;
                }
            }
        }

        System.out.println("前序：" + pre);
        System.out.println("中序：" + in);
        System.out.println("后序：" + post);
    }


    public static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }
}
