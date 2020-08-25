package com.solution;

// Find the length of the smallest subarray in it which when sorted will sort the whole array.
public class Main {
    public static int sort(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < arr.length - 1 && arr[left] <= arr[left + 1]) left++;
        if (left == arr.length - 1) return 0;
        while (right > 0 && arr[right] >= arr[right - 1]) right--;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        while (left > 0 && arr[left - 1] > min) left--;
        while (right < arr.length - 1 && arr[right + 1] < max) right++;

        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        System.out.println(sort(new int[]{1, 3, 2, 0, -1, 7, 10}));
        System.out.println(sort(new int[]{1, 2, 3}));
        System.out.println(sort(new int[]{3, 2, 1}));
    }
}
