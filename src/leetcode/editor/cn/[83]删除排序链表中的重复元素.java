package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 删除排序链表中的重复元素
 * 2024-05-31 11:21:44
 */
class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();

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
                return deleteDuplicates(head.next);
            } else {
                head.next = deleteDuplicates(head.next);
                return head;
            }
        }


        public ListNode deleteDuplicates1(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode p1 = head;
            ListNode p2;
            while ((p2 = p1.next) != null) {
                if (p1.val == p2.val) {
                    p1.next = p2.next;
                } else {
                    p1 = p1.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}