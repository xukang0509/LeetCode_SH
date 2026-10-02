package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 环形链表 II
 * 2024-05-31 21:13:17
 */
@SuppressWarnings("ALL")
class LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    ListNode p = head, q = slow;
                    while (p != q) {
                        p = p.next;
                        q = q.next;
                    }
                    return p;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}