package com.solution;

import java.util.*;

// Find the top ‘K’ frequently occurring numbers in it.
public class Main {
    public static List<Integer> findTopKFrequentNum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) minHeap.poll();
        }
        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) res.add(minHeap.poll().getKey());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findTopKFrequentNum(new int[]{1, 3, 5, 12, 11, 12, 11}, 2));
        System.out.println(findTopKFrequentNum(new int[]{5, 12, 11, 3, 11}, 2));
    }
}
