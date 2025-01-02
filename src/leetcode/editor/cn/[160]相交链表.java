package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 相交链表
 * 2024-05-31 21:25:13
 */
class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA, p2 = headB;
            while (true) {
                if (p1 == p2) {
                    return p1;
                }
                if (p1 != null) {
                    p1 = p1.next;
                } else {
                    p1 = headB;
                }
                if (p2 != null) {
                    p2 = p2.next;
                } else {
                    p2 = headA;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}