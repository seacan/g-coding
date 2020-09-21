package com.solution;

import java.util.*;

// Find ‘K’ pairs with the largest sum where each pair consists of numbers from both the arrays.
public class Main {
    public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap = new PriorityQueue<int[]>(
                Comparator.comparingInt(a -> a[0] + a[1]));
        for (int i = 0; i < k; i++)
            for (int j = 0; j < k; j++) {
                if (minHeap.size() < k)
                    minHeap.offer(new int[]{nums1[i], nums2[j]});
                else {
                    if (nums1[i] + nums2[j] < minHeap.peek()[0] + minHeap.peek()[1])
                        break;
                    else {
                        minHeap.poll();
                        minHeap.offer(new int[]{nums1[i], nums2[j]});
                    }
                }
            }
        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] l1 = new int[]{9, 8, 2};
        int[] l2 = new int[]{6, 3, 1};
        List<int[]> res = findKLargestPairs(l1, l2, 3);
        // Output: [9, 3], [9, 6], [8, 6] 
        for (int[] pairs : res) System.out.println(Arrays.toString(pairs));
    }
}
