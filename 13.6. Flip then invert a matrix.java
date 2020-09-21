package com.solution;

// Flip the image horizontally, then invert it.
public class Main {
    public static void flip(int[][] arr) {
        for (int[] row : arr) {
            int len = row.length;
            for (int i = 0; i < (len + 1) / 2; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[len - i - 1] ^ 1;
                row[len - i - 1] = temp;
            }
        }
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        flip(arr1);
        print(arr1);
        System.out.println();
        int[][] arr2 = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        flip(arr2);
        print(arr2);
    }
}
