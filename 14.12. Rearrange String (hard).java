package com.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// Find if its letters can be rearranged in such a way that no two same characters come next to each other.
public class Main {
    public static String rearrange(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        Queue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();
        Map.Entry<Character, Integer> pre = null;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> cur = maxHeap.poll();
            res.append(cur.getKey());
            if (pre != null) maxHeap.offer(pre);
            cur.setValue(cur.getValue() - 1);
            pre = cur.getValue() > 0 ? cur : null;
        }
        return res.length() == str.length() ? res.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println(rearrange("aappp"));
        System.out.println(rearrange("Programming"));
        System.out.println(rearrange("aapa"));
    }
}
