package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 K 个升序链表
 * 2024-05-31 15:42:13
 */
class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode[] lists = {
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6),
                null,
        };
        Solution solution = new MergeKSortedLists().new Solution();
        solution.mergeKLists(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            // 1. 使用 jdk 的优先级队列实现
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
            for (ListNode list : lists) {
                if (list != null) queue.offer(list);
            }
            ListNode s = new ListNode(-1, null);
            ListNode p = s;
            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                p.next = node;
                p = node;
                if (node.next != null) queue.offer(node.next);
            }
            return s.next;
        }

        public ListNode mergeKLists3(ListNode[] lists) {
            // 大顶堆
            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> b.val - a.val);
            for (ListNode list : lists) {
                ListNode p = list;
                while (p != null) {
                    priorityQueue.offer(p);
                    p = p.next;
                }
            }
            // 每次拿到最大的值，按照头插法插入元素
            ListNode newHead = new ListNode(-1, null);
            while (!priorityQueue.isEmpty()) {
                ListNode node = priorityQueue.poll();
                node.next = newHead.next;
                newHead.next = node;
            }
            return newHead.next;
        }


        public ListNode mergeKLists2(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int l, int r) {
            if (l == r) return lists[l];
            if (l > r) return null;
            int mid = (l + r) >>> 1;
            ListNode left = merge(lists, l, mid);
            ListNode right = merge(lists, mid + 1, r);
            return mergeTwoLists(left, right);
        }


        public ListNode mergeKLists1(ListNode[] lists) {
            ListNode cur = null;
            for (ListNode list : lists) {
                cur = mergeTwoLists(cur, list);
            }
            return cur;
        }

        public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
            ListNode s = new ListNode(-1, null);
            ListNode p3 = s;
            while (p1 != null && p2 != null) {
                if (p1.val >= p2.val) {
                    p3.next = p2;
                    p2 = p2.next;
                } else {
                    p3.next = p1;
                    p1 = p1.next;
                }
                p3 = p3.next;
            }
            if (p1 != null) p3.next = p1;
            if (p2 != null) p3.next = p2;
            return s.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}