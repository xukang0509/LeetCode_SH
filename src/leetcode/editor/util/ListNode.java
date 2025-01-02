package leetcode.editor.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int... nums) {
        ListNode head = new ListNode(-1, null);
        ListNode p = head;
        for (int num : nums) {
            p.next = new ListNode(num, null);
            p = p.next;
        }
        return head.next;
    }

    public static String print(ListNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode p = node;
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) sb.append(" -> ");
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
