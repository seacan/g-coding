package com.solution;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    int value = 0;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

// Check if the LinkedList is a palindrome or not.
public class Main {
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != slow) {
            stack.push(head.value);
            head = head.next;
        }

        if (fast != null) slow = slow.next;
        while (!stack.isEmpty()) {
            int value = stack.pop();
            if (value != slow.value) return false;
            slow = slow.next;
        }
        return slow == null;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(2);
        System.out.println(isPalindrome(head));

        head.next.next.next.next.next = new Node(2);
        System.out.println(isPalindrome(head));
    }
}
