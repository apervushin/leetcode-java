package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/submissions/844765672/
 */
public class GuessNumberHigherOrLower {

    private static class GuessGame {

        private int number;

        public GuessGame(final int number) {
            this.number = number;
        }

        protected int guess(final int num) {
            return Integer.compare(this.number, num);
        }
    }

    private static class Solution extends GuessGame {

        public Solution(int number) {
            super(number);
        }

        public int guessNumber(final int n) {
            int min = 0;
            int max = n;
            while (min < max) {
                final int mid = min + ((max - min) / 2 + ((max - min) % 2 == 0 ? 0 : 1));
                final int guess = guess(mid);
                //System.out.println(min + " " + max + " -> " + mid + " " + guess(mid));
                switch (guess){
                    case 0:
                        return mid;
                    case -1:
                        max = mid;
                        break;
                    case 1:
                        min = mid;
                        break;
                }
            }
            throw new IllegalStateException("Error");
        }

    }

    public static void main(final String[] args) {
        Solution s = new Solution(6);
        System.out.println(s.guessNumber(10));

        s = new Solution(Integer.MAX_VALUE);
        System.out.println(s.guessNumber( Integer.MAX_VALUE));

        s = new Solution(1);
        System.out.println(s.guessNumber(1));

        s = new Solution(1);
        System.out.println(s.guessNumber(2));
    }

}
