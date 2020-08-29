package com.solution;

import java.util.Arrays;

// Find the range of a given number ‘key’.
public class Main {
    public static int[] findRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = findRangeHelper(nums, target, true);
        if (res[0] != -1) res[1] = findRangeHelper(nums, target, false);
        return res;
    }

    private static int findRangeHelper(int[] nums, int target, boolean isFirst) {
        int res = -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < nums[mid]) end = mid - 1;
            else if (target > nums[mid]) start = mid + 1;
            else {
                res = mid;
                if (isFirst) end = mid - 1;
                else start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRange(new int[]{4, 6, 6, 6, 9}, 6)));
        System.out.println(Arrays.toString(findRange(new int[]{1, 3, 8, 10, 15}, 10)));
        System.out.println(Arrays.toString(findRange(new int[]{1, 3, 8, 10, 15}, 12)));
    }
}
