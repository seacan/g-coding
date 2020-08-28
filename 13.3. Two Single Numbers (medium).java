package com.solution;

import java.util.Arrays;

// Every the two numbers that appear only once.
public class Main {
    public static int[] findSingleNums(int[] nums) {
        int n1n2 = 0;
        for (int num : nums) n1n2 ^= num;

        int mostRightSetBit = 1;
        while ((mostRightSetBit & n1n2) == 0) mostRightSetBit = mostRightSetBit << 1;
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & mostRightSetBit) != 0) num1 ^= num;
            else num2 ^= num;
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSingleNums(new int[]{1, 4, 2, 1, 3, 5, 6, 2, 3, 5})));
        System.out.println(Arrays.toString(findSingleNums(new int[]{2, 1, 3, 2})));
    }
}
