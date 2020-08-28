package com.solution;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }
}

// Find the length of its diameter.
public class Main {
    public static int findDiameter(TreeNode root) {
        int[] diameter = new int[]{0};
        calculateHight(root, diameter);
        return diameter[0];
    }

    private static int calculateHight(TreeNode node, int[] diameter) {
        if (node == null) return 0;
        int left = calculateHight(node.left, diameter);
        int right = calculateHight(node.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right + 1);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.right.left = new TreeNode(11);
        System.out.println(findDiameter(root));
    }
}
