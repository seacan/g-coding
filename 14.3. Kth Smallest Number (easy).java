package com.solution;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// Find Kth smallest number.
public class Main {
    public static int findKSmallestNum(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) maxHeap.offer(nums[i]);
        for (int i = k; i < nums.length; i++)
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKSmallestNum(new int[]{1, 5, 12, 2, 11, 5}, 3));
        System.out.println(findKSmallestNum(new int[]{1, 5, 12, 2, 11, 5}, 4));
        System.out.println(findKSmallestNum(new int[]{5, 12, 11, -1, 12}, 3));
    }
}
