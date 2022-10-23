package in.pervush.leetcode.problems;

/**
 * https://leetcode.com/problems/can-place-flowers/
 */
public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 1) {
                continue;
            }

            if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                --n;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1}, 1));
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1}, 2));
        System.out.println(canPlaceFlowers(new int[] {1,0,1,0,1}, 1));
        System.out.println(canPlaceFlowers(new int[] {0,0,0,0,0}, 1));
        System.out.println(canPlaceFlowers(new int[] {0}, 1));
        System.out.println(canPlaceFlowers(new int[] {1}, 1));
        System.out.println(canPlaceFlowers(new int[] {}, 1));
    }

}
