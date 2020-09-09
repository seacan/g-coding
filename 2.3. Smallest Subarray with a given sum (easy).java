package com.solution;

import static java.lang.Math.min;

// Find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’
public class Main {
    public static int findMinSubArray(int[] arr, int s) {
        int res = Integer.MAX_VALUE, localSum = 0, start = 0;
        for (int end = 0; end < arr.length; end++) {
            localSum += arr[end];
            while (localSum >= s) {  // keep on moving start
                res = min(res, end - start + 1);
                localSum -= arr[start];
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Output: 2
        System.out.println(findMinSubArray(new int[]{2, 1, 5, 2, 3, 2}, 7));
        // Output: 1
        System.out.println(findMinSubArray(new int[]{2, 1, 5, 2, 8}, 7));
        // Output: 3
        System.out.println(findMinSubArray(new int[]{3, 4, 1, 1, 6}, 8));
    }
}
