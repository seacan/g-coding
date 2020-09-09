package com.solution;

import java.util.HashMap;
import java.util.Map;

// Find the length of the longest substring in it with no more than K distinct characters.
public class Main {
    public static int longestSubstringKDistinct(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k) {
            throw new IllegalArgumentException();
        }

        int maxLength = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char tail = str.charAt(end);
            map.put(tail, map.getOrDefault(tail, 0) + 1);
            while (map.size() > k) {
                char head = str.charAt(start);
                map.put(head, map.get(head) - 1);
                if (map.get(head) == 0)   // remove since it's counted in while
                    map.remove(head);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Output: 4
        System.out.println(longestSubstringKDistinct("araaci", 2));
        // Output: 2
        System.out.println(longestSubstringKDistinct("araaci", 1));
        // Output: 5
        System.out.println(longestSubstringKDistinct("cbbebi", 3));
    }
}
