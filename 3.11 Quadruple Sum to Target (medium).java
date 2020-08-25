package com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;   // skip dup1
            for (int j = arr.length - 1; j > i + 2; j--) {
                if (j < arr.length - 1 && arr[j] == arr[j + 1]) continue;   // skip dup2
                int left = i + 1, right = j - 1;
                while (left < right) {
                    int sum = arr[i] + arr[left] + arr[right] + arr[j];
                    if (sum == target) {
                        res.add(Arrays.asList(arr[i], arr[left], arr[right], arr[j]));
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left - 1]) left++;   // skip dup3
                        while (left < right && arr[right] == arr[right + 1]) right--;   // skip dup3
                    } else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1));
        System.out.println(searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2));
    }
}
