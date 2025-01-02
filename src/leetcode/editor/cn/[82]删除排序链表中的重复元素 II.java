package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 删除排序链表中的重复元素 II
 * 2024-05-31 11:36:57
 */
class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();

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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;
            if (head.val == head.next.val) {
                ListNode node = head.next;
                while ((node = node.next) != null && node.val == head.val) ;
                return deleteDuplicates(node);
            }
            head.next = deleteDuplicates(head.next);
            return head;
        }


        public ListNode deleteDuplicates1(ListNode head) {
            if (head == null || head.next == null) return head;
            head = new ListNode(-1, head);
            ListNode p1 = head;
            ListNode p2;
            ListNode p3;
            while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
                if (p2.val == p3.val) {
                    while ((p3 = p3.next) != null && p3.val == p2.val) ;
                    p1.next = p3;
                } else {
                    p1 = p1.next;
                }
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}