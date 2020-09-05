package leetcode;

import base.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Return the linked list sorted as well.
 *
 * @author neilly
 */
public class LC82 {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head, slow = dummy;
        int count;
        while (fast != null) {
            count = 1;
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
                count++;
            }
            if (count == 1) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return dummy.next;
    }

}
