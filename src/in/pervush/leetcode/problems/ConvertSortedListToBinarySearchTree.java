package in.pervush.leetcode.problems;

import in.pervush.leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree {

    public static TreeNode sortedListToBST(ListNode head) {
        //System.out.println(head);
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val, null, null);
        }
        ListNode first = head;
        ListNode second = head;
        ListNode secondPrev = null;

        while (first != null) {
            first = first.next;
            if (first == null) {
                break;
            }
            first = first.next;
            secondPrev = second;
            second = second.next;
        }

        secondPrev.next = null;

        return new TreeNode(
                second.val,
                sortedListToBST(head),
                sortedListToBST(second.next)
        );
    }

    private static void test1() {
        final var head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        System.out.println(sortedListToBST(head));
    }

    private static void test2() {
        final var head = new ListNode(0);
        System.out.println(sortedListToBST(head));
    }

    private static void test3() {
        System.out.println(sortedListToBST(null));
    }

    private static void test4() {
        final var head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);

        System.out.println(sortedListToBST(head));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
