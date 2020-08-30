package com.solution;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// Connect these ropes into one big rope with minimum cost.
public class Main {
    public static int minCost(int[] lengths) {
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i < lengths.length; i++) minHeap.offer(lengths[i]);
        int res = 0;
        while (minHeap.size() > 1) {
            int cur = minHeap.poll() + minHeap.poll();
            res += cur;
            minHeap.offer(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[]{1, 3, 11, 5}));
        System.out.println(minCost(new int[]{3, 4, 5, 6}));
        System.out.println(minCost(new int[]{1, 3, 11, 5, 2}));
    }
}
