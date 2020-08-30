package com.solution;

import java.util.*;

// Find the ‘K’ largest numbers in it.
public class Main {
    public static List<Integer> findKLargestNum(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) minHeap.offer(nums[i]);
        for (int i = k; i < nums.length; i++)
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        System.out.println(findKLargestNum(new int[]{3, 1, 5, 12, 2, 11}, 3));
        System.out.println(findKLargestNum(new int[]{5, 12, 11, -1, 12}, 3));
    }
}
