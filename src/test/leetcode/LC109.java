package leetcode;

import base.ListNode;
import base.TreeNode;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * @author neilly
 */
public class LC109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode foot = head;
        while (foot.next != null) {
            foot = foot.next;
        }
        return creatAVT(head, foot);
    }

    private TreeNode creatAVT(ListNode head, ListNode foot) {
        if (head == null) {
            return null;
        }
        if (head == foot) {
            return new TreeNode(head.val);
        }

        ListNode slow = head, fast = head, leftSlow = head;
        while (fast != foot && fast.next != foot) {
            leftSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == foot) {
            leftSlow = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        leftSlow.next = null;
        root.left = creatAVT(head, leftSlow);
        root.right = creatAVT(slow.next, foot);

        return root;
    }

}
