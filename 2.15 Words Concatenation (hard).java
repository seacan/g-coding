package com.solution;

import java.util.*;

// Find all the starting indices of substrings in the given string that are a concatenation of all the given words exactly once without any overlapping of words.
public class Main {
    public static List<Integer> finWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        int totalLength = 0;
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            totalLength += word.length();
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= str.length() - totalLength; i++) {
            String curString = str.substring(i);
            Map<String, Integer> curMap = new HashMap<>(wordMap);
            while (!curMap.isEmpty()) {
                boolean found = false;
                Set<String> curWords = new HashSet<>(curMap.keySet());   // set is modified in the loop
                for (String word : curWords) {
                    if (curString.startsWith(word)) {
                        found = true;
                        curString = curString.substring(word.length());
                        curMap.put(word, curMap.get(word) - 1);
                        if (curMap.get(word) == 0) curMap.remove(word);
                    }
                }
                if (!found) break;
            }
            if (curMap.isEmpty()) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(finWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(finWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"}));
        System.out.println(finWordConcatenation("tigercattigercatcat", new String[]{"cat", "cat", "tiger"}));
    }
}
