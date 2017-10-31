package Linkedlist;

public class LC160_IntersectionofTwoLinkeLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    /*
    先算出各自长度
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode pnode = headA;
        while (pnode != null) {
            lenA++;
            pnode = pnode.next;
        }
        pnode = headB;
        while (pnode != null) {
            lenB++;
            pnode = pnode.next;
        }
        if (lenA >= lenB) {
            int d = lenA - lenB;
            while (d-- > 0) {
                headA = headA.next;
            }
            while (headA != null && headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        } else
            return getIntersectionNode(headB, headA);
    }
}
