package com.solution;

import java.util.ArrayList;
import java.util.List;

// Find all of its permutations preserving the character sequence but changing case.
public class Main {
    public static List<String> findLetterCasePermutations(String str) {
        List<String> res = new ArrayList<>();
        if (str == null || str.isEmpty()) return res;
        res.add(str);
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                int size = res.size();
                for (int j = 0; j < size; j++) {
                    char[] chars = res.get(j).toCharArray();
                    if (Character.isUpperCase(chars[i]))
                        chars[i] = Character.toLowerCase(chars[i]);
                    else
                        chars[i] = Character.toUpperCase(chars[i]);
                    res.add(new String(chars));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = findLetterCasePermutations("ad52");
        System.out.println(res);
        res = findLetterCasePermutations("ab7c");
        System.out.println(res);
    }
}
