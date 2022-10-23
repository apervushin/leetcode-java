package in.pervush.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

    /**
     * O(n) time complexity, O(1) memory usage
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = getLength(headA);
        int bLength = getLength(headB);
        if (aLength > bLength) {
            for (int i = 0; i < aLength - bLength; ++i) {
                headA = headA.next;
            }
        } else if (bLength > aLength) {
            for (int i = 0; i < bLength - aLength; ++i) {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * O(n) time complexity, O(n) memory usage
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> aNodes = new HashSet<>();
        while (headA != null) {
            aNodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (aNodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    private static int getLength(ListNode node) {
        int result = 0;
        while (node != null) {
            ++result;
            node = node.next;
        }
        return result;
    }
}
