package com.solution;

import java.util.*;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class EmployeeSchedule {
    Interval interval;
    int employeeIndex, scheduleIndex;

    public EmployeeSchedule(Interval interval, int employeeIndex, int scheduleIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.scheduleIndex = scheduleIndex;
    }
}

// Find free interval that is common to all employees.
public class Main {
    public static List<Interval> findFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        Queue<EmployeeSchedule> minHeap =
                new PriorityQueue<EmployeeSchedule>(Comparator.comparingInt(a -> a.interval.start));
        for (int i = 0; i < schedule.size(); i++)
            minHeap.offer(new EmployeeSchedule(schedule.get(i).get(0), i, 0));

        Interval lastInterval = null;
        while (!minHeap.isEmpty()) {
            EmployeeSchedule cur = minHeap.poll();
            if (lastInterval != null) {
                if (lastInterval.end < cur.interval.start) {
                    res.add(new Interval(lastInterval.end, cur.interval.start));
                    lastInterval = cur.interval;
                } else {
                    if (lastInterval.end < cur.interval.end)
                        lastInterval = cur.interval;
                }
            } else
                lastInterval = cur.interval;

            if (schedule.get(cur.employeeIndex).size() > cur.scheduleIndex + 1) {
                minHeap.offer(new EmployeeSchedule(schedule.get(cur.employeeIndex).get(cur.scheduleIndex + 1),
                        cur.employeeIndex, cur.scheduleIndex + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> res = findFreeTime(input);
        // Output: [3,5]
        System.out.println("Free times are:");
        for (Interval i : res) System.out.println("[" + i.start + "," + i.end + "]");

        input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(6, 8))));
        res = findFreeTime(input);
        // Output: [4,6], [8,9]
        System.out.println("Free times are:");
        for (Interval i : res) System.out.println("[" + i.start + "," + i.end + "]");

        input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        res = findFreeTime(input);
        // Output: [5,7]
        System.out.println("Free times are:");
        for (Interval i : res) System.out.println("[" + i.start + "," + i.end + "]");
    }
}
