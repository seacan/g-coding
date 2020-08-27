package com.solution;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// Maximize Capital.
public class Main {
    public static int findMaxCapital(int[] capitals, int[] profits, int projectLimit, int initialCapital) {
        Queue<Integer> minCapitalHeap = new PriorityQueue<>(capitals.length);
        Queue<Integer> maxProfitHeap = new PriorityQueue<>(capitals.length, Collections.reverseOrder());
        for (int i = 0; i < capitals.length; i++) minCapitalHeap.offer(capitals[i]);

        int currentCapital = initialCapital;
        for (int i = 0; i < projectLimit; i++) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek() <= currentCapital)
                maxProfitHeap.offer(profits[minCapitalHeap.poll()]);
            if (maxProfitHeap.isEmpty()) break;
            currentCapital += maxProfitHeap.poll();
        }
        return currentCapital;
    }

    public static void main(String[] args) {
        System.out.println(findMaxCapital(new int[]{0, 1, 2}, new int[]{1, 2, 3}, 2, 1));
        System.out.println(findMaxCapital(new int[]{0, 1, 2, 3}, new int[]{1, 2, 3, 5}, 3, 0));
    }
}
