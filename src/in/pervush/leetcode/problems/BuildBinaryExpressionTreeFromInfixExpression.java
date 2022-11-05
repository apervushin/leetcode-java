package in.pervush.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode.com/problems/build-binary-expression-tree-from-infix-expression/
 */
public class BuildBinaryExpressionTreeFromInfixExpression {

    private static class Node {
        char val;
        Node left;
        Node right;
        Node() {this.val = ' ';}
        Node(char val) { this.val = val; }
        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "{" + val + ", " + left + ", " + right + '}';
        }
    }

    public static Node expTree(final String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return new Node(s.charAt(0));
        }
        final String sPosix = toPosix(s);
        final Deque<Node> nodes = new ArrayDeque<>();

        for (int i = sPosix.length() - 1; i >= 0; --i) {
            final char c = sPosix.charAt(i);

            if (getOperandPriority(c) != -1) {
                final Node node = new Node(c);
                while (!nodes.isEmpty()) {
                    final var peek = nodes.peekLast();
                    if (peek.right == null) {
                        peek.right = node;
                        break;
                    } else if (peek.left == null) {
                        peek.left = node;
                        break;
                    } else {
                        nodes.pollLast();
                    }
                }
                nodes.add(node);
            } else if (nodes.peekLast().right == null) {
                nodes.peekLast().right = new Node(c);
            } else if (nodes.peekLast().left == null) {
                nodes.peekLast().left = new Node(c);
            } else {
                final var pop = nodes.pollLast();
                ++i;
            }
        }

        return nodes.peekFirst();
    }

    private static String toPosix(final String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (getOperandPriority(c) != -1) {
                while (!stack.empty() && getOperandPriority(c) <= getOperandPriority(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            } else if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                throw new IllegalArgumentException(String.format("Unknown character %s", c));
            }

            ++i;
        }

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    private static int getOperandPriority(final char c) {
        if (c == '*' || c == '/') {
            return 2;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        return -1;
    }

    public static void main(final String[] args) {
        System.out.println(expTree("1"));
        System.out.println(expTree("3*4-2*5"));
        System.out.println(expTree("2-3/(5*2)+1"));
    }
}
