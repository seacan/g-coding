package com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<List<Integer>> tripleSumToZero(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            // skip the duplicate element
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    res.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    // move to next different numbers
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1]) left++;
                    while (left < right && arr[right] == arr[right + 1]) right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(tripleSumToZero(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(tripleSumToZero(new int[]{-5, 2, -1, -2, 3}));
    }
}
