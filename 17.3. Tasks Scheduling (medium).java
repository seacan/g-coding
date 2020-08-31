package com.solution;

import java.util.*;

// Given the number of tasks and a list of prerequisite pairs, find out if it is possible to schedule all the tasks.
public class Main {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        if (tasks <= 0) return false;

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            map.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            inDegree.put(prerequisite[1], inDegree.get(prerequisite[1]) + 1);
            map.get(prerequisite[0]).add(prerequisite[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet())
            if (entry.getValue() == 0)
                queue.add(entry.getKey());

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            for (int neighbor : map.get(cur)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0)
                    queue.add(neighbor);
            }
        }
        return res.size() == tasks;

    }

    public static void main(String[] args) {
        System.out.println(isSchedulingPossible(3, new int[][]{{0, 1}, {1, 2}}));
        System.out.println(isSchedulingPossible(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
        System.out.println(isSchedulingPossible(6, new int[][]{{2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2}, {1, 3}}));
    }
}
