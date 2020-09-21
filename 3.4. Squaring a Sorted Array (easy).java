package com.solution;

import java.util.Arrays;

// Create a new array containing squares of all the number of the input array in the sorted order.
public class Main {
    public static int[] makeSquare(int[] arr) {
        int[] res = new int[arr.length];
        int left = 0, right = arr.length - 1, cur = res.length - 1;
        while (left <= right) {
            int leftSquare = (int) Math.pow(arr[left], 2), rightSquare = (int) Math.pow(arr[right], 2);
            if (leftSquare <= rightSquare) {
                res[cur--] = rightSquare;
                right--;
            } else {
                res[cur--] = leftSquare;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Output: [0, 1, 4, 4, 9]
        System.out.println(Arrays.toString(makeSquare(new int[]{-2, -1, 0, 2, 3})));
        // Output: [0, 1, 1, 4, 9]
        System.out.println(Arrays.toString(makeSquare(new int[]{-3, -1, 0, 1, 2})));
    }
}
