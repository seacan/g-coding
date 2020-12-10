package com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Find all of its contiguous subarrays whose product is less than the target number.
public class Main {
    public static List<List<Integer>> findSubArray(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int product = 1, left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (left <= right && product >= target)  // dont't forget to check left <= right
                product /= arr[left++];
            List<Integer> local = new ArrayList<>();
            for (int i = right; i >= left; i--) {   // key is to add reversely to avoid duplicate
                local.add(0, arr[i]);
                res.add(new ArrayList<>(local));
            }
        }
        return res;
    }

    public static List<List<Integer>> findSubArray(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            List<Integer> local = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                product *= arr[j];
                if (product < target) {
                    local.add(arr[j]);
                    res.add(new ArrayList<>(local));
                }
            }
            local.clear();
        }
        
        return res;
    }

    public static void main(String[] args) {
        // Output: [2], [5], [2, 5], [3], [5, 3], [10]
        System.out.println(findSubArray(new int[]{2, 5, 3, 10}, 30));
        // Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
        System.out.println(findSubArray(new int[]{8, 2, 6, 5}, 50));
    }
}
