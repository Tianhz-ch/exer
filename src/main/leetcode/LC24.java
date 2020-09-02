package leetcode;

import base.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * @author neilly
 */
public class LC24 {

    public ListNode swapPairs(ListNode head) {
        ListNode newNode = new ListNode(-1);
        ListNode temp = newNode;
        ListNode t;
        while (head != null && head.next != null) {
            t = head.next.next;
            temp.next = swapTwoNode(head, head.next);
            head = t;
            temp = temp.next.next;
        }
        temp.next = head;
        return newNode.next;
    }

    public ListNode swapTwoNode(ListNode first, ListNode second) {
        ListNode newList = new ListNode(-1, second);
        second.next = first;
        return newList.next;
    }
}
