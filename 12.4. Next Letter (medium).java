package com.solution;

// Find the smallest letter in the given array greater than a given ‘key’.
public class Main {
    public static char searchNextLetter(char[] letters, char target) {
        // handle the equal case as well
        if (target < letters[0] || target >= letters[letters.length - 1]) return letters[0];

        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (letters[mid] == target) return letters[mid + 1];
            if (letters[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return letters[start];
    }

    public static void main(String[] args) {
        System.out.println(searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'f'));
        System.out.println(searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'b'));
        System.out.println(searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'm'));
        System.out.println(searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'h'));
    }
}
