package com.solution;

import java.util.*;

class Job {
    int start, end, load;

    public Job(int start, int end, int load) {
        this.start = start;
        this.end = end;
        this.load = load;
    }
}

// Find the maximum CPU load at any time if all the jobs are running on the same machine
public class Main {
    public static int findMaxLoad(List<Job> jobs) {
        Collections.sort(jobs, Comparator.comparingInt(a -> a.start));
        Queue<Job> minHeap = new PriorityQueue<Job>(jobs.size(), Comparator.comparingInt(a -> a.end));
        int maxLoad = 0, curLoad = 0;
        for (Job job : jobs) {
            while (!minHeap.isEmpty() && job.start > minHeap.peek().end)
                curLoad -= minHeap.poll().load;
            minHeap.offer(job);
            curLoad += job.load;
            maxLoad = Math.max(maxLoad, curLoad);
        }
        return maxLoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<>() {
            {
                add(new Job(1, 4, 3));
                add(new Job(2, 5, 4));
                add(new Job(7, 9, 6));
            }
        };
        System.out.println(findMaxLoad(input));

        input = new ArrayList<>() {
            {
                add(new Job(6, 7, 10));
                add(new Job(2, 4, 11));
                add(new Job(8, 12, 15));
            }
        };
        System.out.println(findMaxLoad(input));

        input = new ArrayList<>() {
            {
                add(new Job(1, 4, 2));
                add(new Job(2, 4, 1));
                add(new Job(3, 6, 5));
            }
        };
        System.out.println(findMaxLoad(input));
    }
}
