package com.solution;

class ArrayReader {
    int[] arr;

    public ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length) return Integer.MAX_VALUE;
        return arr[index];
    }
}

// Find if a given number ‘key’ is present in the array in an infinite sorted array.
public class Main {
    public static int search(ArrayReader reader, int target) {
        int start = 0, end = 1;
        while (reader.get(end) < target) {
            int newStart = end + 1;
            end = (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(reader, target, start, end);
    }

    private static int binarySearch(ArrayReader reader, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == reader.get(mid)) return mid;
            if (target < reader.get(mid)) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[]{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30});
        // Output: 6
        System.out.println(search(reader, 16));
        // Output: -1
        System.out.println(search(reader, 11));
        reader = new ArrayReader(new int[]{1, 3, 8, 10, 15});
        // Output: 4
        System.out.println(search(reader, 15));
        // Output: -1
        System.out.println(search(reader, 200));
    }
}
