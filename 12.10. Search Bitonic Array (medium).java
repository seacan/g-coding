package com.solution;

// Given a Bitonic array, find if a given ‘key’ is present in it.
public class Main {
    public static int search(int[] nums, int target) {
        int maxIndex = findMax(nums);
        int res = binarySearch(nums, target, 0, maxIndex);
        if (res == -1) res = binarySearch(nums, target, maxIndex + 1, nums.length - 1);
        return res;
    }

    private static int findMax(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1]) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3, 8, 4, 3}, 4));
        System.out.println(search(new int[]{3, 8, 3, 1}, 8));
        System.out.println(search(new int[]{1, 3, 8, 12}, 12));
        System.out.println(search(new int[]{10, 9, 8}, 10));
    }
}
