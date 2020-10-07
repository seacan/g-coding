package com.solution;

import java.util.ArrayList;
import java.util.List;

// Find all the duplicate numbers
public class Main {
    public static List<Integer> findDuplicateNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // nums[i] != i + 1 checks if the right number is already at the right position
            // without this checking, even the number at the right position will be added to res
            if (nums[i] != i + 1) {
                // nums[i] != nums[nums[i] - 1] to move the number to the right position
                if (nums[i] != nums[nums[i] - 1]) {
                    int temp = nums[i], j = nums[i] - 1;
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i--;
                } else res.add(nums[i]);
            }
        }

        return res;
    }

    public static List<Integer> findDuplicateNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i], j = nums[i] - 1;
                nums[i] = nums[j];
                nums[j] = temp;
                i--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                res.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 4, 5, 5};
        System.out.println(findDuplicateNumbers2(arr));

        arr = new int[]{5, 4, 7, 2, 3, 5, 3};
        System.out.println(findDuplicateNumbers2(arr));
    }
}
