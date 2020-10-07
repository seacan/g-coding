package com.solution;

import java.util.*;

// Remove ‘K’ numbers from the array such that we are left with maximum distinct numbers.
public class Main {
    public static int findMaxDistinctNumbers(int[] nums, int k) {
        int count = 0;
        if (nums.length <= k) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        Queue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) count++;
            else queue.offer(entry);
        }

        while (k > 0 && !queue.isEmpty()) {
            Map.Entry<Integer, Integer> cur = queue.poll();
            k -= cur.getValue() - 1;
            if (k >= 0) count++;
        }
        if (k > 0) count -= k;
        return count;
    }

    public static void main(String[] args) {
        // Output: 3
        // Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8]
        //              We have to skip 5 because it is not distinct and occurred twice. 
        System.out.println(findMaxDistinctNumbers(new int[]{7, 3, 5, 8, 5, 3, 3}, 2));
        System.out.println(findMaxDistinctNumbers(new int[]{3, 5, 12, 11, 12}, 3));
        System.out.println(findMaxDistinctNumbers(new int[]{1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5}, 2));
    }
}
