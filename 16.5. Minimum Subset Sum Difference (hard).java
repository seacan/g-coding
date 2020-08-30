package com.solution;

// Partition the set into two subsets with minimum difference between their subset sums.
public class Main {
    public static int canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        Integer[][] dp = new Integer[nums.length][sum + 1];
        return canPartitionHelper(dp, nums, sum, 0, 0);
    }

    private static int canPartitionHelper(Integer[][] dp, int[] nums, int sum, int index, int currnetSum) {
        if (index == nums.length) return Math.abs(sum - currnetSum - currnetSum);

        if (dp[index][currnetSum] == null) {
            int diff1 = canPartitionHelper(dp, nums, sum, index + 1, currnetSum + nums[index]);
            int diff2 = canPartitionHelper(dp, nums, sum, index + 1, currnetSum);
            dp[index][currnetSum] = Math.min(diff1, diff2);
        }
        return dp[index][currnetSum];
    }

    public static int canPartitionBottomUp(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) dp[i][0] = true;
        for (int s = 0; s <= sum / 2; s++)
            dp[0][s] = nums[0] == s ? true : false;
        for (int i = 1; i < nums.length; i++)
            for (int s = 1; s <= sum / 2; s++) {
                if (dp[i - 1][s]) dp[i][s] = dp[i - 1][s];
                else if (nums[i] <= s) dp[i][s] = dp[i - 1][s - nums[i]];
            }

        // Find the largest index in the last row which is true.
        int sum1 = 0;
        for (int i = sum / 2; i >= 0; i--)
            if (dp[nums.length - 1][i]) {
                sum1 = i;
                break;
            }

        return Math.abs(sum - sum1 - sum1);
    }

    public static void main(String[] args) {
        System.out.println(canPartitionBottomUp(new int[]{1, 2, 3, 9}));
        System.out.println(canPartitionBottomUp(new int[]{1, 2, 7, 1, 5}));
        System.out.println(canPartitionBottomUp(new int[]{1, 3, 100, 4}));
    }
}
