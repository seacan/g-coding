package com.solution;

// Find the rotation count.
public class Main {
    public static int countRotations(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) return mid + 1;
            if (mid > start && nums[mid - 1] > nums[mid]) return mid;

            if (nums[start] < nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countRotations(new int[]{10, 15, 1, 3, 8}));
        System.out.println(countRotations(new int[]{4, 5, 7, 9, 10, -1, 2}));
        System.out.println(countRotations(new int[]{1, 3, 8, 10}));
    }
}
