package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static Node connect(final Node root) {
        connect(root, null);
        return root;
    }

    private static void connect(final Node root, final Node left) {
        if (root == null) {
            return;
        }
        root.next = left;
        connect(root.left, root.right);
        connect(root.right, left == null ? null : left.left);
    }
}
