package in.pervush.leetcode;

/**
 * https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 */
public class ReplaceAllQuestionsToAvoidConsecutiveRepeatingCharacters {

    private static final String CANDIDATES = "abcdefghijklmnopqrstuvwxyz";

    public static String modifyString(String s) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        char prev = '_';
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            char newC = c != '?' ? c : getReplacementChar(prev, i < s.length() - 1 ? s.charAt(i + 1) : '_');
            sb.append(newC);
            prev = newC;
        }

        return sb.toString();
    }

    private static char getReplacementChar(char prev, char next) {
        for (int i = 0; i < CANDIDATES.length(); ++i) {
            final char c = CANDIDATES.charAt(i);
            if (prev != c && next != c) {
                //System.out.println(prev + " " + next + " " + c);
                return c;
            }
        }
        throw new IllegalStateException("Ooops");
    }

    private static void test1() {
        System.out.println(modifyString("?b"));
    }

    private static void test2() {
        System.out.println(modifyString("ubv?w"));
    }

    private static void test3() {
        System.out.println(modifyString("ubv?"));
    }

    private static void test4() {
        System.out.println(modifyString("j?qg??b"));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
