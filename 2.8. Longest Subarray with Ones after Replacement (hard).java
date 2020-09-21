package com.solution;

import static java.lang.Math.max;

// Allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
public class Main {
    // Track the count for 1
    public static int maxOnesWithReplacement1(int[] arr, int k) {
        int maxLength = 0, start = 0, maxOneCount = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 1)
                maxOneCount++;
            while (end - start + 1 - maxOneCount > k) {
                if (arr[start] == 1)
                    maxOneCount--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    // Track the count for 0
    public static int maxOnesWithReplacement2(int[] arr, int k) {
        int maxLength = 0, start = 0, zeroCount = 0;
        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 0)
                zeroCount++;
            while (zeroCount > k) {
                if (arr[start] == 0)
                    zeroCount--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // Output: 6
        System.out.println(maxOnesWithReplacement2(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        // Output: 9
        System.out.println(maxOnesWithReplacement2(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
