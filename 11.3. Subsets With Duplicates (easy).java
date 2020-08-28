package com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Find all of its distinct subsets with duplicates.
public class Main {
    public static List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = 0;
            if (i > 0 && nums[i] == nums[i - 1])
                start = end + 1;
            end = res.size();
            for (int j = start; j < end; j++) {
                res.add(new ArrayList<>(res.get(j)));
                res.get(res.size() - 1).add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = findSubsets(new int[]{1, 3, 3});
        System.out.println(res);

        res = findSubsets(new int[]{1, 5, 3, 3});
        System.out.println(res);
    }
}
