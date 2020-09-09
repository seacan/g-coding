package com.solution;

import static java.lang.Math.max;

// Find the maximum sum of any contiguous subarray of size ‘k’.
public class Main {
    public static int findMaxSumSubArray(int[] arr, int k) {
        int res = 0, localSum = 0, start = 0;
        for (int end = 0; end < arr.length; end++) {
            localSum += arr[end];
            if (end >= k - 1) {
                res = max(res, localSum);
                localSum -= arr[start];
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Output: 9
        System.out.println(findMaxSumSubArray(new int[]{2, 1, 5, 1, 3, 2}, 3));
        // Output: 7
        System.out.println(findMaxSumSubArray(new int[]{2, 3, 4, 1, 5}, 2));
    }
}
