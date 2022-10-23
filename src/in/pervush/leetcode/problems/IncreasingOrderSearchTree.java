package in.pervush.leetcode.problems;

import in.pervush.leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingOrderSearchTree {

    private static class Response {
        TreeNode head;
        TreeNode tail;
    }

    public TreeNode increasingBST(TreeNode root) {
        return increasingBSTRecursive(root).head;
    }

    private Response increasingBSTRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        final Response leftResponse = increasingBSTRecursive(root.left);
        final Response rightResponse = increasingBSTRecursive(root.right);
        root.left = null;
        root.right = null;
        Response response = new Response();
        if (leftResponse == null && rightResponse == null) {
            response.head = root;
            response.tail = root;
        } else if (leftResponse != null && rightResponse == null) {
            response.head = leftResponse.head;
            leftResponse.tail.right = root;
            response.tail = root;
        } else if (leftResponse == null && rightResponse != null) {
            response.head = root;
            root.right = rightResponse.head;
            response.tail = rightResponse.tail;
        } else {
            response.head = leftResponse.head;
            leftResponse.tail.right = root;
            root.right = rightResponse.head;
            response.tail = rightResponse.tail;
        }

        return response;
    }

    public static void main(String[] args) {
        IncreasingOrderSearchTree solution = new IncreasingOrderSearchTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
//        in.pervush.leetcode.model.TreeNode root = new in.pervush.leetcode.model.TreeNode(2);
//        root.left = new in.pervush.leetcode.model.TreeNode(1);
//        root.right = new in.pervush.leetcode.model.TreeNode(3);

        var result = solution.increasingBST(root);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.right;
        }
        System.out.println();
    }

}
