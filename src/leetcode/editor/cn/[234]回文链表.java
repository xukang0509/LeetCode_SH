package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 回文链表
 * 2024-05-31 18:12:48
 */
class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(2, null);
        ListNode node4 = new ListNode(1, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        boolean palindrome = solution.isPalindrome(node1);
        System.out.println("palindrome = " + palindrome);
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
        public boolean isPalindrome(ListNode head) {
            if (head.next == null) return true;
            // p1:慢指针，中间点；p2:快指针
            ListNode p1 = head, p2 = head;
            ListNode newHead = null;
            // 快慢指针找中间点
            while (p2 != null && p2.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
                // 反转前半部分
                head.next = newHead;
                newHead = head;
                head = p1;
            }
            // 节点数为奇数
            if (p2 != null) p1 = p1.next;
            while (newHead != null) {
                if (newHead.val != p1.val) return false;
                newHead = newHead.next;
                p1 = p1.next;
            }
            return true;
        }


        public boolean isPalindrome1(ListNode head) {
            ListNode middleNode = middleNode(head);
            ListNode reverseList = reverseList(middleNode);
            ListNode p1 = head, p2 = reverseList;
            while (p2 != null) {
                if (p1.val != p2.val) return false;
                p1 = p1.next;
                p2 = p2.next;
            }
            return true;
        }

        public ListNode middleNode(ListNode head) {
            ListNode p1 = head, p2 = head;
            while (p2 != null && p2.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
            }
            return p1;
        }

        public ListNode reverseList(ListNode head) {
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