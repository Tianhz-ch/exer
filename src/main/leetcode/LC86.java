package leetcode;

import base.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * @author neilly
 */
public class LC86 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1, head);
        ListNode newList = new ListNode(-1);
        ListNode t = newList;
        boolean flag;
        ListNode temp;
        while (dummy.next != null) {
            temp = dummy;
            flag = false;
            while (temp.next != null) {
                if (temp.next.val < x) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                t.next = temp.next;
                t = t.next;
                temp.next = temp.next.next;
            } else {
                break;
            }
        }
        t.next = dummy.next;
        return newList.next;
    }

}
