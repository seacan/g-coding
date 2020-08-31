package com.solution;

import java.util.*;

// Write a method to find the correct order of characters in the alien language.
public class Main {
    public static String findOrder(String[] words) {
        if (words == null || words.length == 0) return "";

        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        for (String word : words)
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j), child = w2.charAt(j);
                if (parent != child) {
                    inDegree.put(child, inDegree.get(child) + 1);
                    graph.get(parent).add(child);
                    break;  // only the first different char will help find the order
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet())
            if (entry.getValue() == 0)
                queue.add(entry.getKey());
        StringBuilder sorted = new StringBuilder();
        while (!queue.isEmpty()) {
            Character cur = queue.poll();
            sorted.append(cur);
            for (char neighbor : graph.get(cur)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0)
                    queue.add(neighbor);
            }
        }
        return sorted.length() == inDegree.size() ? sorted.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(findOrder(new String[]{"ba", "bc", "ac", "cab"}));
        System.out.println(findOrder(new String[]{"cab", "aaa", "aab"}));
        System.out.println(findOrder(new String[]{"ywx", "wz", "xww", "xz", "zyy", "zwz"}));
    }
}
