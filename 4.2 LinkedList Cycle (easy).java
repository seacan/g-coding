package com.solution;

class Node {
    int value = 0;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

// Determine if the LinkedList has a cycle.
public class Main {
    public static boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        System.out.println(hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println(hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println(hasCycle(head));
    }
}
