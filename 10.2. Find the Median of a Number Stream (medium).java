package com.solution;

import java.util.PriorityQueue;
import java.util.Queue;

// Find the Median of a Number Stream.
class MedianOfStream {
    Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    public void insert(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        return maxHeap.peek();
    }

}

public class Main {
    public static void main(String[] args) {
        MedianOfStream stream = new MedianOfStream();
        stream.insert(3);
        stream.insert(1);
        System.out.println(stream.findMedian());
        stream.insert(5);
        System.out.println(stream.findMedian());
        stream.insert(4);
        System.out.println(stream.findMedian());
    }
}
