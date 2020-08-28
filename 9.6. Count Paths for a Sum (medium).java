package com.solution;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }
}

// Find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
public class Main {
    public static int countPath(TreeNode root, int S) {
        if (root == null) return 0;
        if (root.value == S) return 1;
        return countPath(root.left, S - root.value) + countPath(root.left, S) +
                countPath(root.right, S - root.value) + countPath(root.right, S);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println(countPath(root, 11));
    }
}
