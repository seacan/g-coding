package com.solution;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Node {
    int row, col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

// Find the Kth smallest element in the matrix.
public class Main {
    public static int findKthSmallest(int[][] m, int k) {
        Queue<Node> minHeap = new PriorityQueue<Node>(
                Comparator.comparingInt(a -> m[a.row][a.col]));
        for (int i = 0; i < m.length; i++) {
            minHeap.add(new Node(i, 0));
        }
        int count = 0, res = 0;
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            res = m[cur.row][cur.col];
            if (++count == k) break;
            if (cur.col + 1 < m[cur.row].length)
                minHeap.offer(new Node(cur.row, cur.col + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
        System.out.println(findKthSmallest(m, 5));

    }
}
