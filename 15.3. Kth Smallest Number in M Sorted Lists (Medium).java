package com.solution;

import java.util.*;

class Node {
    int arrayIndex, elementIndex;

    public Node(int arrayIndex, int elementIndex) {
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

// Find the K’th smallest number among all the arrays.
public class Main {
    public static int findKthSmallest(List<Integer[]> lists, int k) {
        Queue<Node> minHeap = new PriorityQueue<Node>(
                Comparator.comparingInt(a -> lists.get(a.arrayIndex)[a.elementIndex]));
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).length != 0) minHeap.add(new Node(i, 0));
        }
        int count = 0, res = 0;
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            res = lists.get(cur.arrayIndex)[cur.elementIndex];
            if (++count == k) break;
            if (cur.elementIndex + 1 < lists.get(cur.arrayIndex).length)
                minHeap.offer(new Node(cur.arrayIndex, cur.elementIndex + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[]{2, 6, 8};
        Integer[] l2 = new Integer[]{3, 6, 7};
        Integer[] l3 = new Integer[]{1, 3, 4};
        List<Integer[]> lists = new ArrayList<>(Arrays.asList(l1, l2, l3));
        System.out.println(findKthSmallest(lists, 5));

    }
}
