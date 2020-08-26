package com.solution;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// Find out if a person can attend all the appointments.
public class Main {
    public static boolean isConflicting(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start <= intervals[i - 1].end) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Interval[] interval = new Interval[]{new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        System.out.println(isConflicting(interval));
        interval = new Interval[]{new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
        System.out.println(isConflicting(interval));
        interval = new Interval[]{new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
        System.out.println(isConflicting(interval));
    }
}
