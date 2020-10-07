package com.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find all anagrams of the pattern in the given string.
public class Main {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char c : pattern.toCharArray())
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);        

        int start = 0, match = 0;
        List<Integer> res = new ArrayList<>();
        for (int end = 0; end < str.length(); end++) {
            char tail = str.charAt(end);
            if (patternMap.containsKey(tail)) {
                patternMap.put(tail, patternMap.get(tail) - 1);
                if (patternMap.get(tail) == 0)
                    match++;
            }

            if (match == patternMap.size())
                res.add(start);

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

        return res;
    }

    public static void main(String[] args) {
        // Output: [1, 2]
        System.out.println(findStringAnagrams("ppqp", "pq"));
        // Output: [2, 3, 4]
        System.out.println(findStringAnagrams("abbcabc", "abc"));
    }
}
