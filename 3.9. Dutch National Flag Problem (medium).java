package com.solution;

import java.util.Arrays;

// Given an array containing 0s, 1s and 2s, sort the array in-place.
public class Main {
    public static void sort(int[] arr) {
        int left = 0, right = arr.length - 1;
        for (int i = 0; i <= right; i++) {
            if (arr[i] == 0) {
                int temp = arr[left];
                arr[left++] = arr[i];
                arr[i] = temp;   // left side only has 1 and 0, no need to move back i
            } else if (arr[i] == 1) continue;
            else {
                int temp = arr[right];
                arr[right--] = arr[i];
                arr[i--] = temp;   // recheck moved right index, hence i--
            }
        }
    }

    // Simplified version
    public static void sort(int[] arr) {
        int l = 0, r = arr.length - 1;
        for (int i = 0; i <= r; i++) {
            if (arr[i] == 0) {
                arr[i] = arr[l];
                arr[l++] = 0;
            } else if (arr[i] == 2) {
                arr[i--] = arr[r];
                arr[r--] = 2;
            }
        }
    }

    public static void main(String[] args) {
        // Output: [0 0 1 1 2]
        int[] arr = new int[]{1, 0, 2, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        // Output: [0 0 1 2 2 2 ]
        arr = new int[]{2, 2, 0, 1, 2, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
