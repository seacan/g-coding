package com.solution;

// Find that duplicate number.
public class Main {
    public static int findDuplicateNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    int temp = nums[i], j = nums[i] - 1;
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i--;
                } else return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 4, 3, 2};
        System.out.println(findDuplicateNumber(arr));

        arr = new int[]{2, 1, 3, 3, 5, 4};
        System.out.println(findDuplicateNumber(arr));

        arr = new int[]{2, 4, 1, 4, 4};
        System.out.println(findDuplicateNumber(arr));
    }
}
