package com.solution;

// Assigned either a ‘+’ or ‘-’ sign, find the total ways to assign symbols to make the sum of the
// numbers equal to the target ‘S’.
public class Main {
    public static int findTargetSubSets(int[] nums, int s) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (s > sum || ((s + sum) % 2 == 1)) return 0;
        return findTargetSubSetsHelper(nums, (s + sum) / 2);
    }

    public static int findTargetSubSetsHelper(int[] nums, int sum) {
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

    public static int findTargetSubSetsHelperOptimized(int[] nums, int sum) {
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
        System.out.println(findTargetSubSets(new int[]{1, 1, 2, 3}, 1));
        System.out.println(findTargetSubSets(new int[]{1, 2, 7, 1}, 9));
    }
}
