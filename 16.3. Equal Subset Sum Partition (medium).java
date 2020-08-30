package com.solution;

// Find if we can partition it into two subsets such that the sum of elements in both subsets is equal.
public class Main {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];
        return canPartitionHelper(dp, nums, sum / 2, 0);
    }

    private static boolean canPartitionHelper(Boolean[][] dp, int[] nums, int sum, int index) {
        if (sum == 0) return true;
        if (index >= nums.length) return false;
        if (dp[index][sum] == null) {
            if (nums[index] <= sum)
                if (canPartitionHelper(dp, nums, sum - nums[index], index + 1))
                    return true;
            dp[index][sum] = canPartitionHelper(dp, nums, sum, index + 1);
        }

        return dp[index][sum];
    }

    public static boolean canPartitionBottomUp(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;

        sum /= 2;
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
        System.out.println(canPartitionBottomUp(new int[]{1, 2, 3, 4}));
        System.out.println(canPartitionBottomUp(new int[]{1, 1, 3, 4, 7}));
        System.out.println(canPartitionBottomUp(new int[]{2, 3, 4, 6}));
    }
}
