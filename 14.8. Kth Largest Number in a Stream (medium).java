package com.solution;

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargestNumberInStream {
    Queue<Integer> minHeap = new PriorityQueue<>();
    int k;

    public KthLargestNumberInStream(int[] nums, int k) {
        this.k = k;
        for (int num : nums) add(num);
    }

    public int add(int num) {
        minHeap.offer(num);
        if (minHeap.size() > k) minHeap.poll();
        return minHeap.peek();
    }
}

// Find the Kth largest element in a stream of numbers.
public class Main {
    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 5, 12, 2, 11};
        KthLargestNumberInStream stream = new KthLargestNumberInStream(input, 4);
        System.out.println(stream.add(6));
        System.out.println(stream.add(13));
        System.out.println(stream.add(4));
    }
}
