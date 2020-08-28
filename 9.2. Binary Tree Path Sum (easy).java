package com.solution;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }
}

// Find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
public class Main {
    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.value == sum && root.left == null && root.right == null)
            return true;
        return hasPath(root.left, sum - root.value) || hasPath(root.right, sum - root.value);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println(hasPath(root, 23));
        System.out.println(hasPath(root, 16));
    }
}
