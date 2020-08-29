package com.solution;

// Find if a given number ‘key’ is present in the array
public class Main {
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        boolean isAscending = nums[start] < nums[end];
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                if (isAscending) end = mid - 1;
                else start = mid + 1;
            } else {
                if (isAscending) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 6, 10}, 10));
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        System.out.println(search(new int[]{10, 6, 4}, 10));
        System.out.println(search(new int[]{10, 6, 4}, 4));
    }
}
