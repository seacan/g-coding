package com.solution;

class Node {
    int value = 0;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

// Check if the LinkedList is a palindrome or not.
public class Main {
    public static void reorder(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head, slowpre = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slowpre = slow;
            slow = slow.next;
        }

        slowpre.next = null;
        Node second = new Node(0);
        while (slow != null) {
            Node next = slow.next;
            slow.next = second.next;
            second.next = slow;
            slow = next;
        }
        second = second.next;

        Node newhead = new Node(0), cur = newhead;
        boolean firstHalf = true;
        while (head != null && second != null) {
            if (firstHalf) {
                cur.next = head;
                head = head.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            firstHalf = !firstHalf;
            cur = cur.next;
        }
        if (second != null) cur.next = second;
        head = newhead.next;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(12);
        reorder(head);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
