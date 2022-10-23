package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/submissions/
 */
public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, final int val) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (current.val != val) {
                prev = current;
            } else {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
            }
            current = current.next;
        }
        return head;
    }

    private static void test1() {
        final int val = 6;
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.println(head + ", " + val);
        System.out.println(removeElements(head, val));
        System.out.println();
    }

    private static void test2() {
        final int val = 2;
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(head + ", " + val);
        System.out.println(removeElements(head, val));
        System.out.println();
    }

    private static void test3() {
        final int val = 1;
        final ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);

        System.out.println(head + ", " + val);
        System.out.println(removeElements(head, val));
        System.out.println();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
