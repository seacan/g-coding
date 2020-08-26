package com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// Insert interval.
public class Main {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty()) return new ArrayList<>(Arrays.asList(newInterval));

        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }

        return res;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.println("New intervals:");
        for (Interval i : insert(input, new Interval(4, 6))) {
            System.out.println("[" + i.start + "," + i.end + "] ");
        }

        input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 6));
        input.add(new Interval(8, 12));
        System.out.println("New intervals:");
        for (Interval i : insert(input, new Interval(4, 10))) {
            System.out.println("[" + i.start + "," + i.end + "] ");
        }

        input = new ArrayList<>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.println("New intervals:");
        for (Interval i : insert(input, new Interval(1, 4))) {
            System.out.println("[" + i.start + "," + i.end + "] ");
        }
    }
}
