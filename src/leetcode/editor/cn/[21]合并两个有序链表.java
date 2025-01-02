package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 合并两个有序链表
 * 2024-05-31 14:46:23
 */
class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();

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
        public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
            if (p1 == null) return p2;
            if (p2 == null) return p1;

            if (p1.val < p2.val) {
                p1.next = mergeTwoLists(p1.next, p2);
                return p1;
            } else  {
                p2.next = mergeTwoLists(p1, p2.next);
                return p2;
            }
        }


        public ListNode mergeTwoLists1(ListNode p1, ListNode p2) {
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