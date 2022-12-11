package in.pervush.leetcode.problems;

import in.pervush.leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {

    private static class State {
        int result = Integer.MIN_VALUE;
    }

    public static int maxPathSum(final TreeNode root) {
        final var state = new State();
        maxPathSum(root, state);
        return state.result;
    }

    private static int maxPathSum(final TreeNode root, final State state) {
        if (root == null) {
            return 0;
        }
        final var left = maxPathSum(root.left, state);
        final var right = maxPathSum(root.right, state);

        state.result = Math.max(state.result, Math.max(left, 0) + Math.max(right, 0) + root.val);
        final int maxSubPath = Math.max(Math.max(left, right), 0) + root.val;
        //System.out.println(root + " " + state.result + " " + maxSubPath);
        return maxSubPath;
    }

    private static void test1() {
        final TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }

    public static void main(final String[] args) {
        test1();
    }
}
