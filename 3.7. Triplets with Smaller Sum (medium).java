package com.solution;

import java.util.Arrays;

// Count all triplets in it such that sum < target.
public class Main {
    public static int searchTriplet(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < target) {
                    count += right - left;   // count range
                    left++;
                } else right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Output: 2
        System.out.println(searchTriplet(new int[]{-1, 0, 2, 3}, 3));
        // Output: 4
        System.out.println(searchTriplet(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}
