package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 排序链表
 * 2024-07-19 09:37:45
 */
@SuppressWarnings("all")
class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();

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
        public ListNode sortList(ListNode head) {
            if (head == null) return null;
            int length = 0;
            ListNode node = head;
            while (node != null) {
                length++;
                node = node.next;
            }
            ListNode newHead = new ListNode(0, head);
            for (int subLength = 1; subLength < length; subLength <<= 1) {
                ListNode prev = newHead, curr = newHead.next;
                while (curr != null) {
                    ListNode head1 = curr;
                    for (int i = 1; i < subLength && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode head2 = curr.next;
                    curr.next = null;
                    curr = head2;
                    for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                        curr = curr.next;
                    }
                    ListNode next = null;
                    if (curr != null) {
                        next = curr.next;
                        curr.next = null;
                    }
                    ListNode merged = merge(head1, head2);
                    prev.next = merged;
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    curr = next;
                }
            }
            return newHead.next;
        }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode newHead = new ListNode();
            ListNode p = newHead;
            while (head1 != null && head2 != null) {
                if (head1.val <= head2.val) {
                    p.next = head1;
                    head1 = head1.next;
                } else {
                    p.next = head2;
                    head2 = head2.next;
                }
                p = p.next;
            }
            if (head1 != null) {
                p.next = head1;
            } else if (head2 != null) {
                p.next = head2;
            }
            return newHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}