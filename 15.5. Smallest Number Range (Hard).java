package com.solution;

import java.util.*;

class Node {
    int arrayIndex, elementIndex;

    public Node(int arrayIndex, int elementIndex) {
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

// Find the smallest range that includes at least one number from each of the ‘M’ lists.
public class Main {
    public static int[] findSmallestRange(List<Integer[]> lists) {
        Queue<Node> minHeap = new PriorityQueue<Node>(
                Comparator.comparingInt(a -> lists.get(a.arrayIndex)[a.elementIndex]));
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).length != 0) {
                minHeap.add(new Node(i, 0));
                currentMax = Math.max(currentMax, lists.get(i)[0]);
            }
        }
        int start = 0, end = Integer.MAX_VALUE;
        while (minHeap.size() == lists.size()) {
            Node cur = minHeap.poll();
            if (currentMax - lists.get(cur.arrayIndex)[cur.elementIndex] < end - start) {
                start = lists.get(cur.arrayIndex)[cur.elementIndex];
                end = currentMax;
            }
            if (cur.elementIndex + 1 < lists.get(cur.arrayIndex).length) {
                minHeap.offer(new Node(cur.arrayIndex, cur.elementIndex + 1));
                currentMax = Math.max(currentMax, lists.get(cur.arrayIndex)[cur.elementIndex + 1]);
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[]{1, 5, 8};
        Integer[] l2 = new Integer[]{4, 12};
        Integer[] l3 = new Integer[]{7, 8, 10};
        List<Integer[]> lists = new ArrayList<>(Arrays.asList(l1, l2, l3));
        System.out.println(Arrays.toString(findSmallestRange(lists)));
    }
}
