package com.solution;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }
}

// Find the total sum of all the numbers represented by all paths.
public class Main {
    public static int findPathSum(TreeNode root) {
        return findPathSumHelper(root, 0);
    }

    private static int findPathSumHelper(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = 10 * sum + root.value;
        if (root.left == null && root.right == null)
            return sum;
        return findPathSumHelper(root.left, sum) + findPathSumHelper(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println(findPathSum(root));
    }
}
