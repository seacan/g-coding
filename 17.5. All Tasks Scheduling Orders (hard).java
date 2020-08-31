package com.solution;

import java.util.*;

// Find the ordering of tasks we should pick to finish all tasks.
public class Main {
    public static List<List<Integer>> findOrders(int tasks, int[][] prerequisites) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        if (tasks <= 0) return res;

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            inDegree.put(prerequisite[1], inDegree.get(prerequisite[1]) + 1);
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        findOrdersHelper(graph, inDegree, solution, res);
        return res;

    }

    private static void findOrdersHelper(Map<Integer, List<Integer>> graph, Map<Integer, Integer> inDegree,
                                         List<Integer> solution, List<List<Integer>> res) {
        Set<Integer> candidateSets = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet())
            if (entry.getValue() == 0)
                candidateSets.add(entry.getKey());
        for (int candidate : candidateSets) {
            solution.add(candidate);
            inDegree.remove(candidate);
            if (solution.size() == graph.size())
                res.add(new ArrayList<>(solution));
            for (int neighbor : graph.get(candidate))
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);

            findOrdersHelper(graph, inDegree, solution, res);

            solution.remove(solution.size() - 1);
            inDegree.put(candidate, 0);
            for (int neighbor : graph.get(candidate))
                inDegree.put(neighbor, inDegree.get(neighbor) + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findOrders(3, new int[][]{{0, 1}, {1, 2}}));
        System.out.println(findOrders(4, new int[][]{{3, 2}, {3, 0}, {2, 0}, {2, 1}}));
        System.out.println(findOrders(6, new int[][]{{2, 5}, {0, 5}, {0, 4}, {1, 4}, {3, 2}, {1, 3}}));
    }
}
