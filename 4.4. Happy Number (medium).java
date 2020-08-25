package com.solution;

// Check if the number is a happy number.
public class Main {
    public static boolean isHappyNumber(int num) {
        int slow = num, fast = num;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private static int squareSum(int num) {
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(23));
        System.out.println(isHappyNumber(12));
    }
}
