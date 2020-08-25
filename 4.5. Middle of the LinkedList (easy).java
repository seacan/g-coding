package com.solution;

class Node {
    int value = 0;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

// Find the middle node of the LinkedList.
public class Main {
    public static Node middleOfList(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println(middleOfList(head).value);

        head.next.next.next.next.next = new Node(6);
        System.out.println(middleOfList(head).value);

        head.next.next.next.next.next.next = new Node(7);
        System.out.println(middleOfList(head).value);
    }
}
