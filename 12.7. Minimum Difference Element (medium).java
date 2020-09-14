package com.solution;

// Find the element in the array that has the minimum difference with the given ‘key’.
public class Main {
    public static int searchMinDiff(int[] nums, int target) {
        if (target < nums[0]) return nums[0];
        if (target > nums[nums.length - 1]) return nums[nums.length - 1];
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return nums[mid];
            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return nums[start] - target < target - nums[end] ? nums[start] : nums[end];
    }

    public static void main(String[] args) {
        System.out.println(searchMinDiff(new int[]{4, 6, 10}, 7));
        System.out.println(searchMinDiff(new int[]{4, 6, 10}, 4));
        System.out.println(searchMinDiff(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(searchMinDiff(new int[]{4, 6, 10}, 17));
    }
}
