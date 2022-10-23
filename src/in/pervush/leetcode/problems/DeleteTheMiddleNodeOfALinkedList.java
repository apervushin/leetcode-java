package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */
public class DeleteTheMiddleNodeOfALinkedList {

    public static ListNode deleteMiddle(ListNode head) {
        boolean both = false;
        ListNode first = head;
        ListNode second = head;
        ListNode prevSecond = null;

        while (first != null) {
            first = first.next;
            if (both){
                prevSecond = second;
                second = second.next;
            }
            both = !both;
        }

        if (prevSecond != null) {
            prevSecond.next = prevSecond.next.next;
        } else if (second != null) {
            return null;
        }

        return head;
    }

    private static void test1() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(head);
        System.out.println(deleteMiddle(head));
        System.out.println();
    }

    private static void test2() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println(head);
        System.out.println(deleteMiddle(head));
        System.out.println();
    }

    private static void test3() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.println(head);
        System.out.println(deleteMiddle(head));
        System.out.println();
    }

    private static void test4() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        System.out.println(head);
        System.out.println(deleteMiddle(head));
        System.out.println();
    }

    private static void test5() {
        final ListNode head = new ListNode(1);

        System.out.println(head);
        System.out.println(deleteMiddle(head));
        System.out.println();
    }

    private static void test6() {
        final ListNode head = null;

        System.out.println(head);
        System.out.println(deleteMiddle(head));
        System.out.println();
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
}
