package in.pervush.leetcode;

/**
 * https://leetcode.com/problems/add-digits/
 */
public class AddDigits {

    public int addDigits(int num) {
        while (num >= 10) {
            int nextNum = 0;
            while (num != 0) {
                nextNum += num % 10;
                num /= 10;
            }
            num = nextNum;
        }

        return num;
    }

}
