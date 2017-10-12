package Linkedlist;

public class LC21_MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode lr = new ListNode(0);
        ListNode h = lr;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                lr.next = l1;
                lr = lr.next;
                l1 = l1.next;
            }
            else {
                lr.next = l2;
                lr = lr.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) lr.next = l1;
        if (l2 != null) lr.next = l2;
        return h.next;
    }
}
