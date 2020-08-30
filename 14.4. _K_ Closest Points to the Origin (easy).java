package com.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distanceToOrigin() {
        return x * x + y * y;
    }
}

// Find ‘K’ closest points to the origin.
public class Main {
    public static List<Point> findClosestPoints(Point[] points, int k) {
        Queue<Point> maxHeap = new PriorityQueue<>((a, b) -> b.distanceToOrigin() - a.distanceToOrigin());
        for (int i = 0; i < k; i++) maxHeap.offer(points[i]);
        for (int i = k; i < points.length; i++)
            if (points[i].distanceToOrigin() < maxHeap.peek().distanceToOrigin()) {
                maxHeap.poll();
                maxHeap.offer(points[i]);
            }
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(1, 3), new Point(3, 4), new Point(2, -1)};
        List<Point> res = findClosestPoints(points, 2);
        for (Point p : res) System.out.println(p.x + " " + p.y);
    }
}
