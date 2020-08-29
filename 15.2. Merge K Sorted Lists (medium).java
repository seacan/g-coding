package com.solution;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

// Merge them into one sorted list.
public class Main {
    public static Node merge(Node[] lists) {
        Queue<Node> queue = new PriorityQueue<Node>(Comparator.comparingInt(a -> a.val));
        for (Node list : lists) {
            if (list != null) queue.add(list);
        }
        Node preHead = new Node(0), runner = preHead;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.next != null) queue.offer(cur.next);
            cur.next = runner.next;
            runner.next = cur;
            runner = runner.next;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(6);
        l1.next.next = new Node(8);
        Node l2 = new Node(3);
        l2.next = new Node(6);
        l2.next.next = new Node(7);
        Node l3 = new Node(1);
        l3.next = new Node(3);
        l3.next.next = new Node(4);
        Node lists = merge(new Node[]{l1, l2, l3});
        while (lists != null) {
            System.out.println(lists.val);
            lists = lists.next;
        }
    }
}
