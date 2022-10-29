package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/minimum-health-to-beat-game/
 */
public class MinimumHealthToBeatGame {

    public static long minimumHealth(final int[] damage, final int armor) {
        long damageSum = 0;
        int maxDamage = 0;
        for (int i : damage) {
            damageSum += i;
            maxDamage = Math.max(maxDamage, i);
        }

        return damageSum - maxDamage + Math.max(0, maxDamage - armor) + 1;
    }

    public static void main(String[] args) {
        System.out.println(minimumHealth(new int[] {2,7,4,3}, 4));
        System.out.println(minimumHealth(new int[] {2,5,3,4}, 7));
        System.out.println(minimumHealth(new int[] {3,3,3}, 0));
    }
}
