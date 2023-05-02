package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode result = null;

        while (head != null) {
            final var tmp = head.next;
            head.next = result;
            result = head;
            head = tmp;
        }

        return result;
    }
}
