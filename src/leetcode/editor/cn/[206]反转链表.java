package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 反转链表
 * 2024-05-30 16:58:26
 */
class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();

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
        public ListNode reverseList(ListNode head) {
            // 不足两个节点
            if (head == null || head.next == null) return head;
            ListNode temp;
            ListNode newHead = head;
            while ((temp = head.next) != null) {
                head.next = temp.next;
                temp.next = newHead;
                newHead = temp;
            }
            return newHead;
        }


        public ListNode reverseList2(ListNode head) {
            // 不足两个节点
            if (head == null || head.next == null) return head;
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }


        public ListNode reverseList1(ListNode head) {
            // 不足两个节点
            if (head == null || head.next == null) return head;
            ListNode newHead = null;
            while (head != null) {
                ListNode temp = head.next;
                head.next = newHead;
                newHead = head;
                head = temp;
            }
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}