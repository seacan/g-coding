package com.solution;

import java.util.*;

// Find if originalSeq can be uniquely reconstructed from the array of sequences.
public class Main {
    public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
        if (originalSeq.length <= 0) return false;

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] seq : sequences)
            for (int i = 0; i < seq.length; i++) {
                inDegree.put(seq[i], 0);
                graph.put(seq[i], new ArrayList<>());
            }
        for (int[] seq : sequences)
            for (int i = 0; i < seq.length - 1; i++) {
                int parent = seq[i], child = seq[i + 1];
                graph.get(parent).add(child);
                inDegree.put(child, inDegree.get(child) + 1);
            }

        if (originalSeq.length != graph.size()) return false;

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet())
            if (entry.getValue() == 0)
                queue.add(entry.getKey());

        List<Integer> sorted = new LinkedList<>();
        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false;
            if (queue.peek() != originalSeq[sorted.size()]) return false;
            int cur = queue.poll();
            sorted.add(cur);
            for (int neighbor : graph.get(cur)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0)
                    queue.add(neighbor);
            }
        }
        return sorted.size() == originalSeq.length;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct(new int[]{1, 2, 3, 4}, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(canConstruct(new int[]{1, 2, 3, 4}, new int[][]{{1, 2}, {2, 3}, {2, 4}}));
        System.out.println(canConstruct(new int[]{3, 1, 4, 2, 5}, new int[][]{{3, 1, 5}, {1, 4, 2, 5}}));
    }
}
