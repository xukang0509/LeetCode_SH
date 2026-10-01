package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 移除链表元素
 * 2024-05-30 17:25:20
 */
@SuppressWarnings("All")
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
            if (head == null) return null;
            head.next = removeElements(head.next, val);
            if (head.val == val) {
                return head.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}