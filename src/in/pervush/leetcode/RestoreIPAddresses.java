package in.pervush.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {

    private static class Position {
        public final int start;
        public final int end;

        public Position(final int start, final int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<String> restoreIpAddresses(final String s) {
        final List<String> result = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) {
            return result;
        }
        dfs(result, s, 0, new ArrayList<>());
        return result;
    }

    private static void dfs(final List<String> result, final String s, final int startPos,
                            final List<Position> positions) {
        if (positions.size() == 4 && s.length() == startPos) {
            result.add(buildIPString(s, positions));
        }

        for (int i = 1; i <= Math.min(3, s.length() - startPos); ++ i) {
            final String subString = s.substring(startPos, startPos + i);
            if (isValidPart(subString)) {
                positions.add(new Position(startPos, startPos + i));
                dfs(result, s, startPos + i, positions);
                positions.remove(positions.size() - 1);
            }
        }

    }

    private static String buildIPString(final String s, final List<Position> positions) {
        final StringBuilder result = new StringBuilder();
        addIPPart(result, positions.get(0), s);
        for (int i = 1; i < positions.size(); ++i) {
            result.append('.');
            addIPPart(result, positions.get(i), s);
        }
        return result.toString();
    }

    private static void addIPPart(StringBuilder result, Position position, String s) {
        result.append(s, position.start, position.end);
    }

    private static boolean isValidPart(final String s) {
        if(s.length() == 0) {
            return false;
        }
        if (s.length() != 1 && s.charAt(0) == '0') {
            return false;
        }
        if (s.length() > 3) {
            return false;
        }
        return Integer.parseInt(s) <= 255;
    }

    private static void test1() {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    private static void test2() {
        System.out.println(restoreIpAddresses("0000"));
    }

    private static void test3() {
        System.out.println(restoreIpAddresses("101023"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
