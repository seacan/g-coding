package com.solution;

import java.util.*;

// Find the topological ordering of its vertices.
public class Main {
    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (vertices <= 0) return res;

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            inDegree.put(edge[1], inDegree.get(edge[1]) + 1);
            map.get(edge[0]).add(edge[1]);
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
        return res.size() == vertices ? res : new ArrayList<>();

    }

    public static void main(String[] args) {
        System.out.println(sort(4, new int[][]{{3, 2}, {3, 0}, {2, 0}, {2, 1}}));
        System.out.println(sort(5, new int[][]{{4, 2}, {4, 3}, {2, 0}, {2, 1}, {3, 1}}));
        System.out.println(sort(7, new int[][]{{6, 4}, {6, 2}, {5, 3}, {5, 4}, {3, 0}, {3, 1}, {3, 2}, {4, 1}}));
    }
}
