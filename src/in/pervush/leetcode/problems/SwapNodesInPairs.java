package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/submissions/
 */
public class SwapNodesInPairs {

    public static ListNode swapPairs(final ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        boolean swap = false;
        while (current != null) {
            if (swap) {
                final int tmp = current.val;
                current.val = prev.val;
                prev.val = tmp;
            }
            prev = current;
            current = current.next;
            swap = !swap;
        }

        return head;
    }
}
