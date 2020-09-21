package com.solution;

// Return the complement of its binary representation.
public class Main {
    public static int bitwiseComplement(int num) {
        int xor = 1, temp = num;
        while (temp != 0) {
            xor = xor << 1;
            temp = temp >> 1;
        }
        return num ^ (xor - 1);
    }

    public static void main(String[] args) {
        // Output: 7, 1000 -> 0111
        System.out.println(bitwiseComplement(8));
        // Output: 5, 1010 -> 0101
        System.out.println(bitwiseComplement(10));
    }
}
