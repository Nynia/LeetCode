package Linkedlist;

public class LC206_ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
    递归和非递归两种做法
     */
    private ListNode df(ListNode head, ListNode prev) {
        if (head == null)
            return prev;
        ListNode next = head.next;
        head.next = prev;
        return df(next, head);
    }
    public ListNode reverseList2(ListNode head) {
        return df(head, null);
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur!= null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
