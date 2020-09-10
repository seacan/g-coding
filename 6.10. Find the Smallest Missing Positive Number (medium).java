package com.solution;

// Find the Smallest Missing Positive Number.
public class Main {
    public static int findNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i], j = nums[i] - 1;
                nums[i] = nums[j];
                nums[j] = temp;
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-3, 1, 5, 4, 2};
        System.out.println(findNumber(arr));

        arr = new int[]{3, -2, 0, 1, 2};
        System.out.println(findNumber(arr));

        arr = new int[]{3, 2, 5, 1};
        System.out.println(findNumber(arr));
    }
}
