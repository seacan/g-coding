package com.solution;

import java.util.*;

// Find all MHTs of the given graph and return a list of their roots.
public class Main {
    public static List<Integer> findTrees(int node, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (node <= 0) return res;
        if (node == 1) {
            res.add(0);
            return res;
        }

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < node; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            inDegree.put(edge[0], inDegree.get(edge[0]) + 1);
            inDegree.put(edge[1], inDegree.get(edge[1]) + 1);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet())
            if (entry.getValue() == 1)
                leaves.add(entry.getKey());

        int count = node;
        while (count > 2) {
            int leaveSize = leaves.size();
            count -= leaveSize;
            // Process all leaves in one batch
            for (int i = 0; i < leaveSize; i++) {
                int cur = leaves.poll();
                for (int neighbor : graph.get(cur)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if (inDegree.get(neighbor) == 1)
                        leaves.add(neighbor);
                }
            }
        }
        res.addAll(leaves);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findTrees(5, new int[][]{{0, 1}, {1, 2}, {1, 3}, {2, 4}}));
        System.out.println(findTrees(4, new int[][]{{0, 1}, {0, 2}, {2, 3}}));
        System.out.println(findTrees(4, new int[][]{{0, 1}, {1, 2}, {1, 3}}));
    }
}
