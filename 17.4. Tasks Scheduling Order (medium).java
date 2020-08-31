package com.solution;

import java.util.*;

// Find the ordering of tasks we should pick to finish all tasks.
public class Main {
    public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        if (tasks <= 0) return res;

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
        return res.size() == tasks ? res : new ArrayList<>();

    }

    public static void main(String[] args) {
        System.out.println(findOrder(3, new int[][]{{0, 1}, {1, 2}}));
        System.out.println(findOrder(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));
        System.out.println(findOrder(6, new int[][]{{2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2}, {1, 3}}));
    }
}
