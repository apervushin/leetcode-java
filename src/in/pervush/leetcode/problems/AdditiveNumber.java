package in.pervush.leetcode.problems;

public class AdditiveNumber {

    public static boolean isAdditiveNumber(final String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 1; i < num.length(); ++i) {
            final String v1 = num.substring(0, i);
            if (!isValidNumber(v1)) {
                continue;
            }
            for (int j = i + 1; j < num.length(); ++j) {
                final String s = num.substring(j);
                final String v2 = num.substring(i, j);
                if (!isValidNumber(v2) || !isValidNumber(s)) {
                    continue;
                }
                if (isAdditiveNumber(s, v1, v2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isAdditiveNumber(final String num, final String v1, final String v2) {
        //System.out.println(num + " " + v1 + " " + v2);
        if (num.isEmpty()) {
            return true;
        }
        final String sum = sum(v1, v2);
        if (!num.startsWith(sum)) {
            return false;
        }
        return isAdditiveNumber(num.substring(sum.length()), v2, sum);
    }

    private static String sum(final String v1, final String v2) {
        return String.valueOf(Long.parseLong(v1) + Long.parseLong(v2));
    }

    private static boolean isValidNumber(final String s) {
        return s.length() == 1 || s.charAt(0) != '0';
    }

    public static void main(final String[] args) {
        System.out.println(isAdditiveNumber("112358") + " (true)");
        System.out.println(isAdditiveNumber("199100199") + " (true)");
        System.out.println(isAdditiveNumber("0") + " (false)");
        System.out.println(isAdditiveNumber("011") + " (true)");
        System.out.println(isAdditiveNumber("111") + " (false)");
        System.out.println(isAdditiveNumber("1023") + " (false)");
    }
}
