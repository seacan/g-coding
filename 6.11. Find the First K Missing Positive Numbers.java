package com.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Find the First K Missing Positive Numbers.
public class Main {
    public static List<Integer> findNumber(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i], j = nums[i] - 1;
                nums[i] = nums[j];
                nums[j] = temp;
                i--;
            }
        }

        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length && res.size() < k; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
                set.add(nums[i]);
            }
        }

        int nextNum = nums.length;
        while (res.size() < k) {
            nextNum = nextNum + 1;
            if (!set.contains(nextNum)) res.add(nextNum);
        }
        return res;
    }

    public static void main(String[] args) {
        // Output: [1, 2, 6]
        int[] arr = new int[]{3, -1, 4, 5, 5};
        System.out.println(findNumber(arr, 3));

        // Output: [1, 5, 6]
        arr = new int[]{2, 3, 4};
        System.out.println(findNumber(arr, 3));

        // Output: [1, 2]
        arr = new int[]{-2, -3, 4};
        System.out.println(findNumber(arr, 2));
    }
}
