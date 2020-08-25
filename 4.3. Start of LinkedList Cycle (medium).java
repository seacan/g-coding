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
        int cycleLength = 0;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }

        Node p1 = head, p2 = head;
        while (cycleLength > 0) {
            p1 = p1.next;
            cycleLength--;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private static int calculateCycleLength(Node node) {
        int cycleLength = 0;
        Node cur = node;
        do {
            node = node.next;
            cycleLength++;
        } while (node != cur);
        return cycleLength;
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
