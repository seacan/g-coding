package com.solution;

import javafx.util.Pair;

import java.util.*;

// Find ‘K’ closest numbers to ‘X’ in the array.
public class Main {
    public static List<Integer> findClosestNumbers(int[] nums, int k, int x) {
        int index = binarySearch(nums, x);
        int low = Math.max(0, index - k), high = Math.min(nums.length - 1, index + k);
        Queue<Pair<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        for (int i = low; i <= high; i++)
            minHeap.offer(new Pair<>(Math.abs(nums[i] - x), nums[i]));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) res.add(minHeap.poll().getValue());
        Collections.sort(res);
        return res;
    }

    private static int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(findClosestNumbers(new int[]{5, 6, 7, 8, 9}, 3, 7));
        System.out.println(findClosestNumbers(new int[]{2, 4, 5, 6, 9}, 3, 6));
        System.out.println(findClosestNumbers(new int[]{2, 4, 5, 6, 9}, 3, 10));
    }
}
