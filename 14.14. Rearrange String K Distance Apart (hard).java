package com.solution;

import java.util.*;

// Find if the string can be rearranged such that the same characters are at least ‘K’ distance apart from each other.
public class Main {
    public static String rearrange(String str, int k) {
        if (k <= 1) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        Queue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> cur = maxHeap.poll();
            res.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            queue.offer(cur);
            if (queue.size() == k && queue.peek().getValue() > 0)
                maxHeap.offer(queue.poll());
        }
        return res.length() == str.length() ? res.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(rearrange("mmpp", 2));
        System.out.println(rearrange("Programming", 3));
        System.out.println(rearrange("aab", 2));
        System.out.println(rearrange("aappa", 3));
    }
}
