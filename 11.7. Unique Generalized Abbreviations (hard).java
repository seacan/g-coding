package com.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AbbreviatedWord {
    StringBuilder str;
    int start, count;

    public AbbreviatedWord(StringBuilder str, int start, int count) {
        this.str = str;
        this.start = start;
        this.count = count;
    }
}

// Generate all of its unique generalized abbreviations.
public class Main {
    public static List<String> generateGeneralizedAbbreviation(String str) {
        List<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) return res;
        if (str.length() == 1) {
            res.add(str);
            res.add("1");
            return res;
        }

        String subString = str.substring(1);
        List<String> subAbs = generateGeneralizedAbbreviation(subString);
        for (String subAb : subAbs) {
            res.add(str.charAt(0) + subAb);
            if (Character.isDigit(subAb.charAt(0))) {
                int prefix = Character.getNumericValue(subAb.charAt(0)) + 1;
                res.add(prefix + subAb.substring(1));
            } else {
                res.add("1" + subAb);
            }
        }

        return res;
    }

    public static List<String> generateGeneralizedAbbreviationWithQueue(String str) {
        int length = str.length();
        List<String> res = new ArrayList<>();
        Queue<AbbreviatedWord> queue = new LinkedList<>();
        queue.offer(new AbbreviatedWord(new StringBuilder(), 0, 0));
        while (!queue.isEmpty()) {
            AbbreviatedWord cur = queue.poll();
            if (cur.start == length) {
                if (cur.count != 0)
                    cur.str.append(cur.count);
                res.add(cur.str.toString());
            } else {
                queue.add(new AbbreviatedWord(new StringBuilder(cur.str), cur.start + 1, cur.count + 1));
                if (cur.count != 0)
                    cur.str.append(cur.count);
                queue.add(new AbbreviatedWord(new StringBuilder(cur.str).append(str.charAt(cur.start)), cur.start + 1, 0));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = generateGeneralizedAbbreviationWithQueue("BAT");
        // Output: [3, 2T, 1A1, 1AT, B2, B1T, BA1, BAT]
        System.out.println(res);
        res = generateGeneralizedAbbreviationWithQueue("code");
        // Output: [4, 3e, 2d1, 2de, 1o2, 1o1e, 1od1, 1ode, c3, c2e, c1d1, c1de, co2, co1e, cod1, code]
        System.out.println(res);
    }
}
