package com.solution;

// Find the missing number.
public class Main {
    public static int findMissingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                int temp = nums[i], j = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 0, 3, 1};
        System.out.println(findMissingNumber(arr));

        arr = new int[]{8, 3, 5, 2, 4, 6, 0, 1};
        System.out.println(findMissingNumber(arr));
    }
}
