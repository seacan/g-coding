package com.solution;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }
}

// Find if the sequence is present as a root-to-leaf path in the given tree.
public class Main {
    public static boolean findPath(TreeNode root, int[] nums) {
        if (root == null) return nums.length == 0;
        return findPathHelper(root, nums, 0);
    }

    private static boolean findPathHelper(TreeNode node, int[] nums, int level) {
        if (node == null) return false;
        if (level >= nums.length) return false;
        if (node.value != nums[level]) return false;
        if (node.left == null && node.right == null && node.value == nums[level]) return true;

        return findPathHelper(node.left, nums, level + 1) || findPathHelper(node.right, nums, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println(findPath(root, new int[]{1, 0, 7}));
        System.out.println(findPath(root, new int[]{1, 1, 6}));
    }
}
