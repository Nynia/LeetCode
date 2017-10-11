package Linkedlist;

public class LC2_AddTwoNumbers {
    /*
    注意最后额外考虑carry=1的情况即可
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode p = list;
        int carry = 0;
        while (true) {
            if (l1 == null) {
                p.next = l2;
                break;
            }
            if (l2 == null) {
                p.next = l1;
                break;
            }
            int sum = l1.val + l2.val + carry;
            carry = 0;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            }
            ListNode node = new ListNode(sum);
            p.next = node;
            p = node;

            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = 0;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            }
            ListNode node = new ListNode(sum);
            p.next = node;
            p = node;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = 0;
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            }
            ListNode node = new ListNode(sum);
            p.next = node;
            p = node;

            l2 = l2.next;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            p.next = node;
        }
        return list.next;
    }
}
