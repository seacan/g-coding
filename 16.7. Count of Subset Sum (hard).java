package com.solution;

// Find the total number of subsets whose sum is equal to a given number ‘S’.
public class Main {
    public static int countSubSets(int[] nums, int sum) {
        Integer[][] dp = new Integer[nums.length][sum + 1];
        return countSubSetsHelper(dp, nums, sum, 0);
    }

    private static int countSubSetsHelper(Integer[][] dp, int[] nums, int sum, int index) {
        if (sum == 0) return 1;
        if (index >= nums.length) return 0;
        if (dp[index][sum] == null)
            dp[index][sum] = (nums[index] <= sum ?
                    countSubSetsHelper(dp, nums, sum - nums[index], index + 1) : 0) +
                    countSubSetsHelper(dp, nums, sum, index + 1);

        return dp[index][sum];
    }

    public static int countSubSetsBottomUp(int[] nums, int sum) {
        int[][] dp = new int[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++) dp[i][0] = 1;
        for (int s = 1; s <= sum; s++) dp[0][s] = nums[0] == s ? 1 : 0;
        for (int i = 1; i < nums.length; i++)
            for (int s = 1; s <= sum; s++) {
                dp[i][s] = dp[i - 1][s];
                if (nums[i] <= s) dp[i][s] += dp[i - 1][s - nums[i]];
            }
        return dp[nums.length - 1][sum];
    }

    public static int countSubSetsBottomUpOptimized(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int s = 1; s <= sum; s++) dp[s] = nums[0] == s ? 1 : 0;
        for (int i = 1; i < nums.length; i++)
            for (int s = sum; s >= 0; s--)
                if (nums[i] <= s)
                    dp[s] += dp[s - nums[i]];

        return dp[sum];
    }

    public static void main(String[] args) {
        System.out.println(countSubSetsBottomUp(new int[]{1, 1, 2, 3}, 4));
        System.out.println(countSubSetsBottomUp(new int[]{1, 2, 7, 1, 5}, 9));
    }
}
