package in.pervush.leetcode.problems;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {

    public static String simplifyPath(final String path) {
        final var tokenizer = new StringTokenizer(path, "/");
        final Stack<String> stack = new Stack<>();

        while (tokenizer.hasMoreTokens()) {
            final var pathPart = tokenizer.nextToken();
            switch (pathPart) {
                case "", ".":
                    break;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(pathPart);
            }
        }

        final var result = new StringBuilder("/");
        for (int i = 0; i < stack.size(); ++i) {
            result.append(stack.get(i));
            if (i != stack.size() - 1) {
                result.append('/');
            }
        }

        return result.toString();
    }
}
