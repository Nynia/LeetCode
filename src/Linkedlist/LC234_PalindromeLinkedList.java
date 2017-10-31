package Linkedlist;

public class LC234_PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
    先找到中点，然后后半段逆向
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode another = null;
        if (fast == null) {
            another = reverseList(slow);
        }
        else
            another = reverseList(slow.next);
        boolean re = true;
        while (another != null) {
            if (head.val != another.val)
                re = false;
            another = another.next;
            head = head.next;
        }
        return re;
    }
}
