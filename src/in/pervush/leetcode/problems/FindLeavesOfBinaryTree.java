package in.pervush.leetcode.problems;

import in.pervush.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    public static List<List<Integer>> findLeaves(final TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    public static int traverse(final TreeNode root, final List<List<Integer>> result) {
        if (root == null) {
            return 0;
        }

        final int depthLeft = traverse(root.left, result);
        final int depthRight = traverse(root.right, result);
        final int depthMax = Math.max(depthLeft, depthRight);

        if (result.size() - 1 < depthMax) {
            result.add(new ArrayList<>());
        }
        result.get(depthMax).add(root.val);

        return depthMax + 1;
    }

    private static void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(findLeaves(root));
    }

    public static void main(String[] args) {
        test1();
    }

}
