package com.solution;

import java.util.ArrayList;
import java.util.List;

// Find all of its distinct subsets.
public class Main {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                res.add(new ArrayList<>(res.get(i)));
                res.get(res.size() - 1).add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = findSubsets(new int[]{1, 3});
        System.out.println(res);

        res = findSubsets(new int[]{1, 5, 3});
        System.out.println(res);
    }
}
