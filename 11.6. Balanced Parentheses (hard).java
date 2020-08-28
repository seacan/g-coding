package com.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ParenthesesString {
    String str;
    int openCount, closeCount;

    public ParenthesesString(String str, int openCount, int closeCount) {
        this.str = str;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

// Generate all combination of ‘N’ pairs of balanced parentheses.
public class Main {
    public static List<String> generateValidParentheses(int num) {
        List<String> res = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.offer(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesesString cur = queue.poll();
            if (cur.openCount == num && cur.closeCount == num) res.add(cur.str);
            else {
                if (cur.openCount < num)
                    queue.add(new ParenthesesString(cur.str + "(", cur.openCount + 1, cur.closeCount));
                if (cur.openCount > cur.closeCount)
                    queue.add(new ParenthesesString(cur.str + ")", cur.openCount, cur.closeCount + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = generateValidParentheses(2);
        System.out.println(res);
        res = generateValidParentheses(3);
        System.out.println(res);
    }
}
