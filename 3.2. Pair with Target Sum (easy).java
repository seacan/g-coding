package com.solution;

import java.util.Arrays;

// Find a pair in the array whose sum is equal to the given target.
public class Main {
    public static int[] pairWithTargetSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return new int[]{left, right};
            if (sum < target) left++;
            else right--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairWithTargetSum(new int[]{1, 2, 3, 4, 6}, 6)));
        System.out.println(Arrays.toString(pairWithTargetSum(new int[]{2, 5, 9, 11}, 11)));
    }
}
