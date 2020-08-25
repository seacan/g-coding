package com.solution;

import java.util.Arrays;

public class Main {
    public static void sort(int[] arr) {
        int left = 0, right = arr.length - 1;
        for (int i = 0; i <= right; i++) {
            if (arr[i] == 0) {
                int temp = arr[left];
                arr[left++] = arr[i];
                arr[i] = temp;
            } else if (arr[i] == 1) continue;
            else {
                int temp = arr[right];
                arr[right--] = arr[i];
                arr[i--] = temp;   // recheck moved right index, hence i--
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{2, 2, 0, 1, 2, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
