package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * <ul>
 *      <li>val: an integer representing Node.val</li>
 *      <li>random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.</li>
 * </ul>
 *
 * @author neilly
 */
public class LC138 {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node temp1 = head, temp2 = dummy;

        while (temp1 != null) {
            Node temp = new Node(temp1.val);
            map.put(temp1, temp);
            temp2.next = temp;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp1 = head;
        temp2 = dummy.next;
        while (temp1 != null) {
            temp2.random = map.get(temp1.random);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return dummy.next;

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
