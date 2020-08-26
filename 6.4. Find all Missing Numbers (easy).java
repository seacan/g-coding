package com.solution;

import java.util.ArrayList;
import java.util.List;

// Find all those missing numbers with duplicates.
public class Main {
    public static List<Integer> findMissingNumber(int[] nums) {
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
                res.add(i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 8, 2, 3, 5, 1};
        System.out.println(findMissingNumber(arr));

        arr = new int[]{2, 4, 1, 2};
        System.out.println(findMissingNumber(arr));

        arr = new int[]{2, 3, 2, 1};
        System.out.println(findMissingNumber(arr));
    }
}
