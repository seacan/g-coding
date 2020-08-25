package com.solution;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

// Allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
public class Main {
    public static int maxLengthCharReplacement(String str, int k) {
        int maxLength = 0, start = 0, maxRepeatCharCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char tail = str.charAt(end);
            map.put(tail, map.getOrDefault(tail, 0) + 1);
            maxRepeatCharCount = Math.max(maxRepeatCharCount, map.get(tail));

            while (end - start + 1 - maxRepeatCharCount > k) {
                char head = str.charAt(start);
                map.put(head, map.get(head) - 1);
                start++;
            }

            maxLength = max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthCharReplacement("aabccbb", 2));
        System.out.println(maxLengthCharReplacement("abbcb", 1));
        System.out.println(maxLengthCharReplacement("abccde", 1));
    }
}
