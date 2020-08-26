package com.solution;

import java.util.ArrayList;
import java.util.List;

// Find the dup number and missing number.
public class Main {
    public static List<Integer> findNumber(int[] nums) {
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
            if (nums[i] != i + 1) {
                res.add(nums[i]);
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 5, 2};
        System.out.println(findNumber(arr));

        arr = new int[]{3, 1, 2, 3, 6, 4};
        System.out.println(findNumber(arr));
    }
}
