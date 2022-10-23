package in.pervush.leetcode.problems;

public class SwappingNodesInALinkedList {

    public static ListNode swapNodes(final ListNode head, final int k) {
        ListNode current = head;
        ListNode first = null;
        ListNode second = null;
        int i = 1;

        while (current != null) {
            if (i == k) {
                first = current;
                second = head;
            } else if (i > k) {
                second = second.next;
            }
            current = current.next;
            ++i;
        }

        final int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

        return head;
    }

}
