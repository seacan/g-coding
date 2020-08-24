package com.solution;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static boolean stringPermutationMatch(String str, String pattern) {
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }

        int start = 0, match = 0;
        for (int end = 0; end < str.length(); end++) {
            char tail = str.charAt(end);
            if (patternMap.containsKey(tail)) {
                patternMap.put(tail, patternMap.get(tail) - 1);
                if (patternMap.get(tail) == 0)
                    match++;
            }

            if (match == patternMap.size())
                return true;

            if (end - start + 1 >= pattern.length()) {   // same length and move head by 1
                char head = str.charAt(start);
                if (patternMap.containsKey(head)) {
                    if (patternMap.get(head) == 0)
                        match--;
                    patternMap.put(head, patternMap.get(head) + 1);
                }
                start++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(stringPermutationMatch("oidbcaf", "abc"));
        System.out.println(stringPermutationMatch("odicf", "dc"));
        System.out.println(stringPermutationMatch("bcdxabcdy", "bcdyabcdx"));
        System.out.println(stringPermutationMatch("aaacb", "abc"));
    }
}
