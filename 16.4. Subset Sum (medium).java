package com.solution;

// Determine if a subset exists whose sum is equal to a given number ‘S’.
public class Main {
    public static boolean canPartitionBottomUp(int[] nums, int sum) {
        boolean[][] dp = new boolean[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++) dp[i][0] = true;
        for (int s = 0; s <= sum; s++)
            dp[0][s] = nums[0] == s ? true : false;
        for (int i = 1; i < nums.length; i++)
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][s]) dp[i][s] = dp[i - 1][s];
                else if (nums[i] <= s) dp[i][s] = dp[i - 1][s - nums[i]];
            }
        return dp[nums.length - 1][sum];
    }

    public static void main(String[] args) {
        System.out.println(canPartitionBottomUp(new int[]{1, 2, 3, 7}, 6));
        System.out.println(canPartitionBottomUp(new int[]{1, 2, 7, 1, 5}, 10));
        System.out.println(canPartitionBottomUp(new int[]{1, 3, 4, 8}, 6));
    }
}
