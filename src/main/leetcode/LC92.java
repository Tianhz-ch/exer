package leetcode;

import base.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * @author neilly
 */
public class LC92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1, head);
        ListNode t = dummy, ahead = null, end = null, temp;
        int count = 0;
        while (t != null) {
            if (count == m - 1) {
                ahead = t;
            } else if (count == n) {
                end = t;
                break;
            }
            count++;
            t = t.next;
        }
        if (ahead != null && end != null) {
            temp = end.next;
            Pair<ListNode, ListNode> pair = reverseList(ahead.next, end);
            ahead.next = pair.a;
            pair.b.next = temp;
        }

        return dummy.next;
    }

    public Pair<ListNode, ListNode> reverseList(ListNode head, ListNode foot) {
        foot.next = null;
        ListNode dummy = new ListNode(-1);
        ListNode newFoot = head;
        ListNode temp1, temp2;
        while (head != foot) {
            temp1 = dummy.next;
            temp2 = head.next;
            dummy.next = head;
            head.next = temp1;
            head = temp2;
        }
        foot.next = dummy.next;
        return new Pair<>(foot, newFoot);
    }

    static class Pair<A, B> {

        public final A a;
        public final B b;

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }
    }

}

