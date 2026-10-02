package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 * 2024-05-31 10:19:40
 */
@SuppressWarnings("ALL")
class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        solution.removeNthFromEnd(new ListNode(1, null), 1);
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyNode = new ListNode(-1, head);
            remove(dummyNode, n);
            return dummyNode.next;
        }

        private int remove(ListNode p, int n) {
            if (p == null) return 0;
            int num = remove(p.next, n);
            if (num == n) {
                p.next = p.next.next;
            }
            return num + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}