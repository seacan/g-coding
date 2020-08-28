package com.solution;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }
}

// Find the path with the maximum sum in a given binary tree.
public class Main {
    public static int findMaxPathSum(TreeNode root) {
        int[] sum = new int[]{Integer.MIN_VALUE};
        findMaxPathSumHelper(root, sum);
        return sum[0];
    }

    private static int findMaxPathSumHelper(TreeNode node, int[] sum) {
        if (node == null) return 0;
        int left = findMaxPathSumHelper(node.left, sum);
        int right = findMaxPathSumHelper(node.right, sum);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        sum[0] = Math.max(sum[0], left + right + node.value);
        return Math.max(left, right) + node.value;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(findMaxPathSum(root));

        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println(findMaxPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println(findMaxPathSum(root));
    }
}
