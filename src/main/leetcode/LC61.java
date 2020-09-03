package leetcode;

import base.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * @author neilly
 */
public class LC61 {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        if (count != 0 && count != 1) {
            for (int i = 0; i < k % count; i++) {
                head = rotateRightSingle(head);
            }
        }
        return head;
    }

    public ListNode rotateRightSingle(ListNode head) {
        ListNode temp1 = head, temp2 = head.next.next;
        ListNode newHead;
        while (temp2 != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        newHead = temp1.next;
        newHead.next = head;
        temp1.next = null;
        return newHead;
    }
}
