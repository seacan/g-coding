package com.solution;

import java.util.ArrayList;
import java.util.List;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// Find the intersection of these two lists
public class Main {
    public static Interval[] Intersection(Interval[] arr1, Interval[] arr2) {
        List<Interval> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end) ||
                (arr2[i].start >= arr1[j].start && arr2[i].start <= arr1[j].end))
                res.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
            // compare the end field
            if (arr1[i].end < arr2[j].end) i++;
            else j++;
        }

        return res.toArray(new Interval[res.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        Interval[] res = Intersection(input1, input2);
        System.out.println("Intersection intervals:");
        for (Interval i : res) {
            System.out.println("[" + i.start + "," + i.end + "] ");
        }

        input1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        input2 = new Interval[]{new Interval(5, 10)};
        res = Intersection(input1, input2);
        System.out.println("Intersection intervals:");
        for (Interval i : res) {
            System.out.println("[" + i.start + "," + i.end + "] ");
        }
    }
}
