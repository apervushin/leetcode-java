package in.pervush.leetcode.problems;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(final String s) {
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
            if (isOpen(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                final char open = stack.pop();
                if(!isMatch(open, c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpen(final char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private static boolean isMatch(final char open, final char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}
