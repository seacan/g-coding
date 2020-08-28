package com.solution;

// Return the complement of its binary representation.
public class Main {
    public static int bitwiseComplement(int num) {
        int bitCount = 0, temp = num;
        while (temp != 0) {
            bitCount++;
            temp = temp >> 1;
        }
        return num ^ (int) (Math.pow(2, bitCount) - 1);
    }

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(8));
        System.out.println(bitwiseComplement(10));
    }
}
