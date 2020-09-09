package com.solution;

import java.util.Arrays;

// Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
public class Main {
    public static double[] getAverage(int[] arr, int k) {
        double[] res = new double[arr.length - k + 1];
        double localSum = 0;  // avoid not using int
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            localSum += arr[end];
            if (end >= k - 1) {
                res[start] = localSum / k;
                localSum -= arr[start];
                start++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        // Output: [2.2, 2.8, 2.4, 3.6, 2.8]
        double[] res = getAverage(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5);
        System.out.println(Arrays.toString(res));
    }
}
