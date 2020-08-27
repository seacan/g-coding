package com.solution;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }
}

// Find the level order successor of the given node in the tree.
public class Main {
    public static TreeNode findSuccessor(TreeNode root, int value) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode.left != null) queue.offer(curNode.left);
            if (curNode.right != null) queue.offer(curNode.right);
            if (curNode.value == value) break;

        }
        return queue.peek();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode res = findSuccessor(root, 12);
        if (res != null) System.out.println(res.value);
        res = findSuccessor(root, 9);
        if (res != null) System.out.println(res.value);
    }
}
