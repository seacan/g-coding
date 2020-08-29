package com.solution;

// Find the maximum value in a given Bitonic array.
public class Main {
    public static int findMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1]) end = mid;
            else start = mid + 1;
        }
        return nums[start];
    }

    public static void main(String[] args) {
        System.out.println(findMax(new int[]{1, 3, 8, 12, 4, 2}));
        System.out.println(findMax(new int[]{3, 8, 3, 1}));
        System.out.println(findMax(new int[]{1, 3, 8, 12}));
        System.out.println(findMax(new int[]{10, 9, 8}));
    }
}
