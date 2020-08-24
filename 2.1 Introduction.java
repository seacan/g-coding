package com.solution;

import java.util.Arrays;

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
        double[] res = getAverage(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5);
        System.out.println(Arrays.toString(res));
    }
}
