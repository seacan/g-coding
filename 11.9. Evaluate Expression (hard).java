package com.solution;

import java.util.ArrayList;
import java.util.List;

// Find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.
public class Main {
    public static List<Integer> evaluateExpression(String input) {
        List<Integer> res = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") &&
                !input.contains("*") && !input.contains("/")) {
            res.add(Integer.parseInt(input));
        } else {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (!Character.isDigit(c)) {
                    List<Integer> left = evaluateExpression(input.substring(0, i));
                    List<Integer> right = evaluateExpression(input.substring(i + 1));
                    for (int lValue : left)
                        for (int rValue : right) {
                            if (c == '+') res.add(lValue + rValue);
                            if (c == '-') res.add(lValue - rValue);
                            if (c == '*') res.add(lValue * rValue);
                            if (c == '/') res.add(lValue / rValue);
                        }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = evaluateExpression("1+2*3");
        System.out.println(res);
        res = evaluateExpression("2*3-4-5");
        System.out.println(res);
    }
}
