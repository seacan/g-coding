package com.solution;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }
}

// Find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
public class Main {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPathsHelper(root, sum, res, path);
        return res;
    }

    private static void findPathsHelper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        path.add(root.value);
        if (root.value == sum && root.left == null && root.right == null)
            res.add(new ArrayList<>(path));   // add new List instance
        else {
            findPathsHelper(root.left, sum - root.value, res, path);
            findPathsHelper(root.right, sum - root.value, res, path);
        }
        path.remove(path.size() - 1);
    }

    private static void _findPathsHelper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        if (root.left == null && root.right == null && sum == root.value) {
            List<Integer> copy = new ArrayList<>(path);
            copy.add(root.value);
            res.add(copy);
            return;
        }
        path.add(root.value);
        findPathsHelper(root.left, sum - root.value, res, path);
        findPathsHelper(root.right, sum - root.value, res, path);
        path.remove(path.size() - 1);
    }

    public static List<List<Integer>> findPathsWithStack(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (!visited.contains(cur)) {
                path.add(cur.value);
                sum -= cur.value;
            }
            visited.add(cur);
            if (sum == 0 && cur.left == null && cur.right == null)
                res.add(new ArrayList<>(path));
            if (cur.left != null && !visited.contains(cur.left)) stack.push(cur.left);
            if (cur.right != null && !visited.contains(cur.right)) stack.push(cur.right);
            if (visited.contains(stack.peek())) {
                stack.pop();
                sum += cur.value;
                path.remove(path.size() - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println(findPaths(root, 23));
    }
}
