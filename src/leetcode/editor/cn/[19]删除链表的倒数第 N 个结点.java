package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 * 2024-05-31 10:19:40
 */
class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            head = new ListNode(-1, head);
            ListNode p1 = head;
            ListNode p2 = head;
            for (int i = 0; i <= n; i++) {
                p2 = p2.next;
            }
            while (p2 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            p1.next = p1.next.next;
            return head.next;
        }


        public ListNode removeNthFromEnd1(ListNode head, int n) {
            head = new ListNode(-1, head);
            recursion(head, n);
            return head.next;
        }

        private int recursion(ListNode p, int n) {
            if (p == null) return 0;
            int res = recursion(p.next, n);
            if (res == n) {
                p.next = p.next.next;
            }
            return res + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}