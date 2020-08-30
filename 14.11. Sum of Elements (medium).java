package com.solution;

import java.util.PriorityQueue;
import java.util.Queue;

// Find the sum of all numbers between the K1’th and K2’th smallest elements.
public class Main {
    public static int sum(int[] nums, int k1, int k2) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) minHeap.offer(num);
        for (int i = 0; i < k1; i++) minHeap.poll();
        int sum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++) sum += minHeap.poll();
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 3, 12, 5, 15, 11}, 3, 6));
        System.out.println(sum(new int[]{3, 5, 8, 7}, 1, 4));
    }
}
