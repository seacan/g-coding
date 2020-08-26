package com.solution;

class Node {
    int value = 0;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

// Rotate a LinkedList.
public class Main {
    public static Node rotate(Node head, int k) {
        if (head == null || head.next == null || k < 0) return head;
        Node lastNode = head;
        int length = 1;
        while (lastNode.next != null) {
            length++;
            lastNode = lastNode.next;
        }
        int skip = length - k % length;
        Node runner = head, pre = head;
        while (skip > 0) {
            pre = runner;
            runner = runner.next;
            skip--;
        }
        lastNode.next = head;
        pre.next = null;
        return runner;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        Node res = rotate(head, 2);
        while (res != null) {
            System.out.println(res.value);
            res = res.next;
        }
    }
}
