package com.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// Merge all the overlapping intervals.
public class Main {
    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals.size() < 2) return intervals;

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        List<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval last = res.get(res.size() - 1), cur = intervals.get(i);
            if (cur.start <= last.end) {
                last.end = Math.max(last.end, cur.end);
            } else {
                res.add(cur);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.println("Merged intervals:");
        for (Interval i : mergeIntervals(input)) {
            System.out.println("[" + i.start + "," + i.end + "] ");
        }

        input = new ArrayList<>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.println("Merged intervals:");
        for (Interval i : mergeIntervals(input)) {
            System.out.println("[" + i.start + "," + i.end + "] ");
        }

        input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.println("Merged intervals:");
        for (Interval i : mergeIntervals(input)) {
            System.out.println("[" + i.start + "," + i.end + "] ");
        }
    }
}
