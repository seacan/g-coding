package com.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Element {
    int value, freq, sequence;

    public Element(int value, int freq, int sequence) {
        this.value = value;
        this.freq = freq;
        this.sequence = sequence;
    }
}

class FrequencyStack {
    int sequence = 0;
    Queue<Element> maxHeap = new PriorityQueue<Element>((a, b) -> {
        if (a.freq != b.freq) return b.freq - a.freq;
        return b.sequence - a.sequence;
    });
    Map<Integer, Integer> map = new HashMap<>();

    public void push(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        maxHeap.offer(new Element(num, map.get(num), sequence++));
    }

    public int pop() {
        int res = maxHeap.poll().value;
        if (map.get(res) > 1) map.put(res, map.get(res) - 1);
        else map.remove(res);
        return res;
    }
}

// Design a class that simulates a Stack data structure.
public class Main {
    public static void main(String[] args) {
        FrequencyStack stack = new FrequencyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
