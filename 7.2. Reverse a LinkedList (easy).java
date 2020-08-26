package com.solution;

class Node {
    int value = 0;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

// Reverse the LinkedList.
public class Main {
    public static Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node pre = null, cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(10);
        Node res = reverse(head);
        while (res != null) {
            System.out.println(res.value);
            res = res.next;
        }
    }
}
