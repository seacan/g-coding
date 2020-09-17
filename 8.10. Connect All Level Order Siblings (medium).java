package com.solution;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int value;
    TreeNode left, right, next;

    public TreeNode(int value) {
        this.value = value;
    }
}

// Connect each node with its level order successor
public class Main {
    public static void connect(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode preNode = null;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (preNode != null) preNode.next = curNode;
            preNode = curNode;
            if (curNode.left != null) queue.offer(curNode.left);
            if (curNode.right != null) queue.offer(curNode.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        connect(root);
        while (root != null) {
            System.out.println(root.value);
            root = root.next;
        }
    }
}
