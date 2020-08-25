package com.solution;

import java.util.Arrays;

public class Main {
    public static int searchTriplet(int[] arr, int target) {
        Arrays.sort(arr);
        int minDifference = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) return sum;

                if (Math.abs(sum - target) < minDifference || (Math.abs(sum - target) == minDifference && sum - target < minDifference)) {
                    minDifference = Math.abs(sum - target);
                    res = sum;
                }

                if (sum < target) left++;
                else right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-2, 0, 1, 2}, 2));
        System.out.println(searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }
}