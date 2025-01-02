package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 移除链表元素
 * 2024-05-30 17:25:20
 */
class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();

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
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) return head;
            if (head.val == val) {
                return removeElements(head.next, val);
            } else {
                head.next = removeElements(head.next, val);
                return head;
            }
        }

        public ListNode removeElements2(ListNode head, int val) {
            head = new ListNode(-1, head);
            ListNode p1 = head;
            ListNode p2;
            while ((p2 = p1.next) != null) {
                if (p2.val != val) {
                    p1 = p1.next;
                } else {
                    p1.next = p2.next;
                }
            }
            return head.next;
        }

        public ListNode removeElements1(ListNode head, int val) {
            ListNode p = new ListNode(-1, null);
            ListNode res = p;
            while (head != null) {
                if (head.val != val) {
                    p.next = new ListNode(head.val, null);
                    p = p.next;
                }
                head = head.next;
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}