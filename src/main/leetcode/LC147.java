package leetcode;

import base.ListNode;

/**
 * Sort a linked list using insertion sort.
 *
 * @author neilly
 */
public class LC147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode node, temp;
        while (head != null) {
            node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return dummy.next;
    }

}
