package com.solution;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String findMinSubstring(String str, String pattern) {
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }

        int start = 0, match = 0, minLength = str.length() + 1;   // +1 for the initial min length
        String minSubstring = "";
        for (int end = 0; end < str.length(); end++) {
            char tail = str.charAt(end);
            if (patternMap.containsKey(tail)) {
                patternMap.put(tail, patternMap.get(tail) - 1);
                if (patternMap.get(tail) == 0)
                    match++;
            }

            while (match == patternMap.size()) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minSubstring = str.substring(start, end + 1);
                }

                char head = str.charAt(start);
                if (patternMap.containsKey(head)) {
                    if (patternMap.get(head) == 0)
                        match--;
                    patternMap.put(head, patternMap.get(head) + 1);
                }
                start++;
            }
        }

        return minSubstring;
    }

    public static void main(String[] args) {
        System.out.println(findMinSubstring("aabdec", "abc"));
        System.out.println(findMinSubstring("abdabca", "abc"));
        System.out.println(findMinSubstring("adcad", "abc"));
    }
}
