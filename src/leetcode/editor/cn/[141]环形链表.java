package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 环形链表
 * 2024-05-31 20:51:43
 */
@SuppressWarnings("ALL")
class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();

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
        public boolean hasCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}