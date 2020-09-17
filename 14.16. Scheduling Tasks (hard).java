package com.solution;

import java.util.*;

// If the cooling period for all tasks is ‘K’ intervals, find the minimum number of CPU intervals
// that the server needs to finish all tasks.
public class Main {
    public static int scheduleTasks(char[] tasks, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) map.put(task, map.getOrDefault(task, 0) + 1);
        Queue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        int count = 0;
        while (!maxHeap.isEmpty()) {
            Queue<Map.Entry<Character, Integer>> waitList = new LinkedList<>();
            int i = k + 1;
            for (; i > 0 && !maxHeap.isEmpty(); i--) {
                count++;
                Map.Entry<Character, Integer> cur = maxHeap.poll();
                if (cur.getValue() > 1) {
                    cur.setValue(cur.getValue() - 1);
                    waitList.offer(cur);
                }
            }
            maxHeap.addAll(waitList);
            if (!maxHeap.isEmpty()) count += i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(scheduleTasks(new char[]{'a', 'a', 'a', 'b', 'c', 'c'}, 2));
        System.out.println(scheduleTasks(new char[]{'a', 'b', 'a'}, 3));
    }
}
