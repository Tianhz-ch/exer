package leetcode;

import base.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * @author neilly
 */
public class LC25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode newList = new ListNode(-1);
        ListNode newHead, newFoot = newList;
        ListNode temp;
        Pair<ListNode, ListNode> pair;
        int i;
        while (head != null) {
            newHead = head;
            for (i = 1; i < k; i++) {
                head = head.next;
                if (head == null) {
                    break;
                }
            }
            if (i == k) {
                temp = head.next;
                pair = reverseList(newHead, head);
                newFoot.next = pair.a;
                newFoot = pair.b;
                head = temp;
            } else {
                newFoot.next = newHead;
                break;
            }
        }

        return newList.next;
    }

    public Pair<ListNode, ListNode> reverseList(ListNode head, ListNode foot) {
        ListNode newNode = new ListNode(-1);
        ListNode temp1, temp2;
        ListNode newFoot = head;
        while (head != foot) {
            temp1 = newNode.next;
            newNode.next = head;
            temp2 = head.next;
            head.next = temp1;
            head = temp2;
        }
        foot.next = newNode.next;
        return new Pair<>(foot, newFoot);
    }

}

class Pair<A, B> {

    public final A a;
    public final B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }
}
