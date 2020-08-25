package com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<List<Integer>> findSubArray(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i], product = cur;
            if (product < target) res.add(Arrays.asList(cur));
            for (int j = i + 1; j < arr.length; j++) {
                List<Integer> local = new ArrayList<>();
                local.add(cur);
                product *= arr[j];
                if (product < target) {
                    local.add(arr[j]);
                    res.add(new ArrayList<>(local));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findSubArray(new int[]{2, 5, 3, 10}, 30));
        System.out.println(findSubArray(new int[]{8, 2, 6, 5}, 50));
    }
}
