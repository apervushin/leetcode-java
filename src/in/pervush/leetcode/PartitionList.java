package in.pervush.leetcode;

/**
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        final ListNode lessThanXHead = new ListNode(Integer.MIN_VALUE);
        ListNode lessThanXTail = lessThanXHead;
        final ListNode greaterThanXHead = new ListNode(Integer.MAX_VALUE);
        ListNode greaterThanXTail = greaterThanXHead;

        while (head != null) {
            if (head.val < x) {
                lessThanXTail.next = new ListNode(head.val);
                lessThanXTail = lessThanXTail.next;
            } else {
                greaterThanXTail.next = new ListNode(head.val);
                greaterThanXTail = greaterThanXTail.next;
            }
            head = head.next;
        }
        lessThanXTail.next = greaterThanXHead.next;
        return lessThanXHead.next;
    }

    private static void test1() {
        final ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        System.out.println(partition(head, 3));
    }

    public static void main(String[] args) {
        test1();
    }
}
