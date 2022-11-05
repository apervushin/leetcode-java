package in.pervush.leetcode.problems;

import in.pervush.leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/submissions/837518919/
 */
public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

    public static String getDirections(final TreeNode root, final int startValue, final int destValue) {
        final StringBuilder path1 = new StringBuilder();
        final StringBuilder path2 = new StringBuilder();

        find(root, startValue, path1);
        find(root, destValue, path2);

        path1.reverse();
        path2.reverse();
        int i = 0;
        while (i < Math.min(path1.length(), path2.length()) && path1.charAt(i) == path2.charAt(i)) {
            ++i;
        }

        return "U".repeat(path1.length() - i) + path2.substring(i);
    }

    private static boolean find(final TreeNode root, final int val, final StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        } else if (find(root.left, val, path)){
            path.append('L');
        } else if (find(root.right, val, path)){
            path.append('R');
        }
        return !path.isEmpty();
    }

    private static void test1() {
        final TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        System.out.println(getDirections(root, 3, 6));
    }

    private static void test2() {
        final TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        System.out.println(getDirections(root, 2, 1));
    }

    private static void test3() {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(getDirections(root, 2, 1));
    }

    private static void test4() {
        final TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        System.out.println(getDirections(root, 2, 1));
    }

    public static void main(final String[] args) {
        test1();
//        test2();
//        test3();
//        test4();
    }
}
