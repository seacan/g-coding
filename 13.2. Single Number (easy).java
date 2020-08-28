package com.solution;

// Every number appears twice except for one, find that single number.
public class Main {
    public static int findSingleNum(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) num = num ^ nums[i];
        return num;
    }

    public static void main(String[] args) {
        System.out.println(findSingleNum(new int[]{1, 4, 2, 1, 3, 2, 3}));
        System.out.println(findSingleNum(new int[]{7, 9, 7}));
    }
}
