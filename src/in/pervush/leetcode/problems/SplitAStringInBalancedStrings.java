package in.pervush.leetcode.problems;

public class SplitAStringInBalancedStrings {

    public static int balancedStringSplit(String s) {
        int lCnt = 0;
        int rCnt = 0;
        int result = 0;

        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
            switch (c) {
                case 'L':
                    ++lCnt;
                    break;
                case 'R':
                    ++rCnt;
                    break;
                default:
                    throw new IllegalStateException(String.format("Unknown character %s", c));
            }
            if (rCnt == lCnt) {
                result++;
            }
        }

        return result;
    }

    private static void test1() {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }

    private static void test2() {
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
    }

    private static void test3() {
        System.out.println(balancedStringSplit("LLLLRRRR"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
