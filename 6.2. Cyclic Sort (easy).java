package com.solution;

import java.util.Arrays;

// Sort the array.
public class Main {
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i] - 1;
            if (nums[i] != i + 1) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i--;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{2, 6, 4, 3, 1, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{1, 5, 6, 4, 3, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
