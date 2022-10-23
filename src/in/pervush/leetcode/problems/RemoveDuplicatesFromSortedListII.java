package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedListII {

    public static ListNode deleteDuplicates(final ListNode head) {
        final ListNode fakeHead = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = fakeHead;
        ListNode current = head;
        boolean deleteCurrent = false;

        while (current != null) {
            if (current.next == null) {
                if (deleteCurrent) {
                    prev.next = null;
                }
                break;
            }

            if (current.val == current.next.val) {
                deleteCurrent = true;
                current.next = current.next.next;
                continue;
            }

            if (deleteCurrent) {
                prev.next = current.next;
                current = current.next;
                deleteCurrent = false;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return fakeHead.next;
    }

    private static void test1() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println(head);
        System.out.println(deleteDuplicates(head));
        System.out.println();
    }

    private static void test2() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);

        System.out.println(head);
        System.out.println(deleteDuplicates(head));
        System.out.println();
    }

    private static void test3() {
        final ListNode head = new ListNode(1);

        System.out.println(head);
        System.out.println(deleteDuplicates(head));
        System.out.println();
    }

    private static void test4() {
        final ListNode head = null;

        System.out.println(head);
        System.out.println(deleteDuplicates(head));
        System.out.println();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
