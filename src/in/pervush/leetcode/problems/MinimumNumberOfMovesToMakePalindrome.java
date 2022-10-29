package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/
 */
public class MinimumNumberOfMovesToMakePalindrome {

    public static int minMovesToMakePalindrome(final String s) {
        final char[] chars = s.toCharArray();
        return minMovesToMakePalindrome(chars, 0);
    }

    private static int minMovesToMakePalindrome(final char[] chars, final int pos) {
        if (pos >= chars.length / 2) {
            return 0;
        }
        final int endPos = chars.length - pos - 1;

        int i, j;
        for (i = endPos; i >= pos; --i) {
            if (chars[i] == chars[pos]) {
                break;
            }
        }
        for (j = pos; j <= endPos; ++j) {
            if (chars[j] == chars[endPos]) {
                break;
            }
        }

        int result = 0;
        if (endPos - i <= j - pos) {
            result += move(chars, i, endPos, pos);
        } else {
            result += move(chars, j, pos, pos);
        }
        result += minMovesToMakePalindrome(chars, pos + 1);

        return result;
    }

    private static int move(final char[] chars, int fromPos, int toPos, int pos) {
        if (fromPos == toPos) {
            return 0;
        }
        final char c = chars[fromPos];
        int result = 0;
        if (fromPos < toPos) {
            for (int i = fromPos; i < toPos; ++i) {
                chars[i] = chars[i + 1];
                result++;
            }
        } else {
            for (int i = fromPos; i > toPos; --i) {
                chars[i] = chars[i - 1];
                result++;
            }
        }

        chars[toPos] = c;
        return result;
    }


    public static void main(final String[] args) {
        System.out.println(minMovesToMakePalindrome("aabb") + " (2)");
        System.out.println(minMovesToMakePalindrome("letelt") + " (2)");
        System.out.println(minMovesToMakePalindrome("eqvvhtcsaaqtqesvvqch") + " (17)");
        System.out.println(minMovesToMakePalindrome("skwhhaaunskegmdtutlgtteunmuuludii") + " (163)");
    }
}
