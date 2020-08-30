package com.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// Sort it based on the decreasing frequency of its characters.
public class Main {
    public static String sortCharacterByFrequency(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> cur = maxHeap.poll();
            for (int i = 0; i < cur.getValue(); i++)
                res.append(cur.getKey());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortCharacterByFrequency("Programming"));
        System.out.println(sortCharacterByFrequency("abcbab"));
    }
}
