package in.pervush.leetcode;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val + " -> " + (next == null ? "null" : next.toString());
    }
}
