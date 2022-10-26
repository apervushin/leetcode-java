package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/remove-letter-to-equalize-frequency/submissions/
 */
public class RemoveLetterToEqualizeFrequency {

    public static boolean equalFrequency(final String word) {
        final var chars = new int[26]; // character -> count
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            chars[c - 'a']++;
        }

        for (int i = 0; i < chars.length; ++i) {
            chars[i]--;
            if (isEqualCount(chars)) {
                return true;
            }
            chars[i]++;
        }

        return false;
    }

    private static boolean isEqualCount(final int[] chars) {
        int cnt = 0;
        for (final int value : chars) {
            if (value == 0) {
                continue;
            } else if (cnt == 0) {
                cnt = value;
            } else if (cnt != value) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("aaaabbbbccc " + equalFrequency("aaaabbbbccc") + " (false)");
        System.out.println("cccaa " + equalFrequency("cccaa") + " (true)");
        System.out.println("zz " + equalFrequency("zz") + " (true)");
        System.out.println("aca " + equalFrequency("aca") + " (true)");
        System.out.println("abc " + equalFrequency("abc") + " (true)");
        System.out.println("cbccca " + equalFrequency("cbccca") + " (false)");
        System.out.println("abcc " + equalFrequency("abcc") + " (true)");
        System.out.println("aazz " + equalFrequency("aazz") + " (false)");
    }
}
