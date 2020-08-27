package com.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int value;
    TreeNode left, right, next;

    public TreeNode(int value) {
        this.value = value;
    }
}

// Connect each node with its level order successor.
public class Main {
    public static void connect(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode preNode = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (preNode != null) preNode.next = curNode;
                preNode = curNode;
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
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
        List<TreeNode> heads = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (i == 0) heads.add(curNode);
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
        }
        for (TreeNode head : heads) {
            List<Integer> curLevel = new ArrayList<>();
            while (head != null) {
                curLevel.add(head.value);
                head = head.next;
            }
            System.out.println(curLevel);
        }
    }
}
