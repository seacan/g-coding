package com.solution;

class Node {
    int value = 0;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

// Find the starting node of the cycle.
public class Main {
    public static Node findCycleStart(Node head) {
        if (head == null) return null;
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println(findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println(findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println(findCycleStart(head).value);
    }
}
