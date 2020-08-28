package com.solution;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

// Return all structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’.
public class Main {
    public static List<TreeNode> findUniqueTrees(int n) {
        if (n <= 0) return new ArrayList<>();
        return findUniqueTreesHelper(1, n);
    }

    private static List<TreeNode> findUniqueTreesHelper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = findUniqueTreesHelper(start, i - 1);
            List<TreeNode> rightSubtrees = findUniqueTreesHelper(i + 1, end);
            for (TreeNode left : leftSubtrees)
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> res = findUniqueTrees(2);
        System.out.println(res.size());
        res = findUniqueTrees(3);
        System.out.println(res.size());
    }
}
