package com.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Find all of its permutations.
public class Main {
    public static List<List<Integer>> findPermutations(int[] nums) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());
        for (int num : nums) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> cur = queue.poll();
                for (int j = 0; j <= cur.size(); j++) {
                    List<Integer> newPerm = new ArrayList<>(cur);
                    newPerm.add(j, num);
                    queue.add(newPerm);
                }
            }
        }
        return (List) queue;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = findPermutations(new int[]{1, 3, 5});
        System.out.println(res);
    }
}
