package com.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.max;

// Find the length of the longest substring which has no repeating characters.
public class Main {
    public static int noRepeatedSubstringWithSet(String str) {
        int maxLength = 0, start = 0;
        Set<Character> set = new HashSet<>();
        for (int end = 0; end < str.length(); end++) {
            while (set.contains(str.charAt(end))) {
                set.remove(str.charAt(start));
                start++;
            }
            set.add(str.charAt(end));
            maxLength = max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static int noRepeatedSubstringWithMap(String str) {
        int maxLength = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            if (map.containsKey(str.charAt(end))) {
                start = map.get(str.charAt(end)) + 1;   // move start index
            }
            map.put(str.charAt(end), end);
            maxLength = max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(noRepeatedSubstringWithMap("aabccbb"));
        System.out.println(noRepeatedSubstringWithMap("abbbb"));
        System.out.println(noRepeatedSubstringWithMap("abccde"));
    }
}
