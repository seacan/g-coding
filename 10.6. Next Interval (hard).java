package com.solution;

import java.util.Arrays;
import java.util.PriorityQueue;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// Find the next interval.
public class Main {
    public static int[] findNextIntervals(Interval[] intervals) {
        PriorityQueue<Integer> maxStartHeap =
                new PriorityQueue<>(intervals.length, (a, b) -> intervals[b].start - intervals[a].start);
        PriorityQueue<Integer> maxEndHeap =
                new PriorityQueue<>(intervals.length, (a, b) -> intervals[b].end - intervals[a].end);
        for (int i = 0; i < intervals.length; i++) {
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int topEnd = maxEndHeap.poll();
            int topStart = -1;
            while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end)
                topStart = maxStartHeap.poll();
            res[topEnd] = topStart;
            if (topStart != -1) maxStartHeap.offer(topStart);
        }
        return res;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{new Interval(2, 3), new Interval(3, 4), new Interval(5, 6)};
        System.out.println(Arrays.toString(findNextIntervals(intervals)));
        intervals = new Interval[]{new Interval(3, 4), new Interval(1, 5), new Interval(4, 6)};
        System.out.println(Arrays.toString(findNextIntervals(intervals)));
    }
}
