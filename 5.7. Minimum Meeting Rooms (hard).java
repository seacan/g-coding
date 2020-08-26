package com.solution;

import java.util.*;

class Meeting {
    int start, end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// Find the minimum number of rooms required to hold all the meetings.
public class Main {
    public static int findMinMeetingRooms(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0) return 0;

        Collections.sort(meetings, Comparator.comparingInt(a -> a.start));
        Queue<Meeting> minHeap = new PriorityQueue<Meeting>(meetings.size(), Comparator.comparingInt(a -> a.end));
        int minRooms = 0;
        for (Meeting meeting : meetings) {
            while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
                minHeap.poll();
            }
            minHeap.offer(meeting);
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }

    public static void main(String[] args) {
        List<Meeting> input = new ArrayList<>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        System.out.println(findMinMeetingRooms(input));

        input = new ArrayList<>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(7, 9));
            }
        };
        System.out.println(findMinMeetingRooms(input));

        input = new ArrayList<>() {
            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        System.out.println(findMinMeetingRooms(input));

        input = new ArrayList<>() {
            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        System.out.println(findMinMeetingRooms(input));

        input = new ArrayList<>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        System.out.println(findMinMeetingRooms(input));
    }
}
