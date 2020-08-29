package com.solution;

// Find the ceiling of a given number ‘key’.
public class Main {
    public static int searchCeiling(int[] nums, int target) {
        if (target >= nums[nums.length - 1]) return -1;

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(searchCeiling(new int[]{4, 6, 10}, 6));
        System.out.println(searchCeiling(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(searchCeiling(new int[]{4, 6, 10}, 17));
        System.out.println(searchCeiling(new int[]{4, 6, 10}, -1));
    }
}
