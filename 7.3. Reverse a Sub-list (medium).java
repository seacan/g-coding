package com.solution;

class Node {
    int value = 0;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

// Reverse the LinkedList between p and q.
public class Main {
    public static Node reverse(Node head, int p, int q) {
        if (p == q) return head;

        Node newHead = new Node(0), runner = newHead;
        int i = 1;
        for (; i < p; i++) {
            Node cur = head;
            head = head.next;
            cur.next = runner.next;
            runner.next = cur;
            runner = runner.next;
        }
        for (; i <= q; i++) {
            Node cur = head;
            head = head.next;
            cur.next = runner.next;
            runner.next = cur;
        }
        while (runner.next != null) runner = runner.next;
        while (head != null) {
            Node cur = head;
            head = head.next;
            cur.next = runner.next;
            runner.next = cur;
            runner = runner.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node res = reverse(head, 2, 4);
        while (res != null) {
            System.out.println(res.value);
            res = res.next;
        }
    }
}
