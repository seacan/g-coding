package com.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// Find the median for the sliding window.
class SlidingWindowMedian {
    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek())
                maxHeap.offer(nums[i]);
            else
                minHeap.offer(nums[i]);
            rebalance();

            if (i >= k - 1) {
                res[i - k + 1] = maxHeap.size() == minHeap.size() ?
                        (double) (maxHeap.peek() + minHeap.peek()) / 2 : maxHeap.peek();
                // Check which heap to remove from.
                if (nums[i - k + 1] <= maxHeap.peek())
                    maxHeap.remove(nums[i - k + 1]);
                else
                    minHeap.remove(nums[i - k + 1]);
                rebalance();
            }
        }
        return res;
    }

    private void rebalance() {
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }
}

public class Main {
    public static void main(String[] args) {
        SlidingWindowMedian median = new SlidingWindowMedian();
        System.out.println(Arrays.toString(median.findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 2)));
        median = new SlidingWindowMedian();
        System.out.println(Arrays.toString(median.findSlidingWindowMedian(new int[]{1, 2, -1, 3, 5}, 3)));
    }
}
