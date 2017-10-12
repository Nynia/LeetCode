package Linkedlist;

public class LC19_RemoveNthNodeFromEndofList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode prev = h;
        while(n != 0 && p2 != null) {
            p2 = p2.next;
            n--;
        }
        if (n > 0) return p1;
        while (p2 != null) {
            prev = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        prev.next = p1.next;
        return h.next;
    }
}
