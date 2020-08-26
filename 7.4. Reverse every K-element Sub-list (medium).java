package com.solution;

class Node {
    int value = 0;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

// Reverse the LinkedList by k.
public class Main {
    public static Node reverse(Node head, int k) {
        Node newHead = new Node(0), runner = newHead;
        while (head != null) {
            for (int i = 0; i < k && head != null; i++) {
                Node cur = head;
                head = head.next;
                cur.next = runner.next;
                runner.next = cur;
            }
            while (runner.next != null) runner = runner.next;
        }
        return newHead.next;
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
        Node res = reverse(head, 3);
        while (res != null) {
            System.out.println(res.value);
            res = res.next;
        }
    }
}
