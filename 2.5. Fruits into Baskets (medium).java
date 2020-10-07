package com.solution;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

// Given k baskets and your goal is to put maximum number of fruits in each basket.
public class Main {
    public static int maxFruitCountOfKType(char[] arr, int k) {
        int maxLength = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < arr.length; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            while (map.size() > k) {
                map.put(arr[start], map.get(arr[start]) - 1);
                if (map.get(arr[start]) == 0)
                    map.remove(arr[start]);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // Output: 3
        System.out.println(maxFruitCountOfKType(new char[]{'A', 'B', 'C', 'A', 'C'}, 2));
        // Output: 5
        System.out.println(maxFruitCountOfKType(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}, 2));
    }
}
