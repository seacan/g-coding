package com.solution;

// Remove all duplicates from it, not use any extra space.
public class Main {
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 1) return 1;

        int cur = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[cur] != arr[i])
                arr[++cur] = arr[i];            
        }
        return cur + 1;
    }

    public static int removeDuplicates(int[] arr) {
        if (arr.length == 1) return 1;
        int cur = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[cur++] = arr[i];
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        // Output: 4
        System.out.println(removeDuplicates(new int[]{2, 3, 3, 3, 6, 9, 9}));
        // Output: 2
        System.out.println(removeDuplicates(new int[]{2, 2, 2, 11}));
    }
}
