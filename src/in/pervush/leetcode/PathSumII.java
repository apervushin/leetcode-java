package in.pervush.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        final List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            dfs(result, new ArrayList<>(), root, targetSum);
        }
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> currentPath, TreeNode root, int targetSum) {
        currentPath.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                result.add(new ArrayList<>(currentPath));
            }
        } else {
            if (root.left != null) {
                dfs(result, currentPath, root.left, targetSum);
            }
            if (root.right != null) {
                dfs(result, currentPath, root.right, targetSum);
            }
        }

        currentPath.remove(currentPath.size() - 1);
    }

    private static void test1() {
        final TreeNode root = new TreeNode(
                5,
                new TreeNode(
                        4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)),
                        null
                ),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(2)))
        );
        System.out.println(pathSum(root, 22));
    }

    public static void main(String[] args) {
        test1();
    }
}
