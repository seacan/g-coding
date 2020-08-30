package com.solution;

// Carry some fruits in the knapsack to get maximum profit.
public class Main {
    public static int solveKnapsack(int[] weights, int[] profits, int capacity) {
        Integer[][] dp = new Integer[weights.length][capacity + 1];
        return solveKnapsackHelper(dp, weights, profits, capacity, 0);
    }

    private static int solveKnapsackHelper(Integer[][] dp, int[] weights, int[] profits, int capacity, int index) {
        if (capacity <= 0 || index >= weights.length) return 0;
        if (dp[index][capacity] != null) return dp[index][capacity];
        int profit1 = 0;
        if (weights[index] <= capacity)
            profit1 = profits[index] +
                    solveKnapsackHelper(dp, weights, profits, capacity - weights[index], index + 1);
        int profit2 = solveKnapsackHelper(dp, weights, profits, capacity, index + 1);
        dp[index][capacity] = Math.max(profit1, profit2);
        return dp[index][capacity];
    }

    public static int solveKnapsackBottomUp(int[] weights, int[] profits, int capacity) {
        if (capacity <= 0 || profits.length == 0 || profits.length != weights.length) return 0;
        int len = weights.length;
        int[][] dp = new int[len][capacity + 1];
        for (int i = 0; i < len; i++) dp[i][0] = 0;
        for (int c = 0; c <= capacity; c++)
            dp[0][c] = weights[0] <= c ? profits[0] : 0;
        for (int i = 1; i < len; i++)
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                profit2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        return dp[len - 1][capacity];
    }

    // Another less optimized solution is to keep a int[2][capacity+1]
    public static int solveKnapsackBottomUpOptimized(int[] weights, int[] profits, int capacity) {
        if (capacity <= 0 || profits.length == 0 || profits.length != weights.length) return 0;
        int len = weights.length;
        int[] dp = new int[capacity + 1];
        for (int c = 0; c <= capacity; c++)
            dp[c] = weights[0] <= c ? profits[0] : 0;
        for (int i = 1; i < len; i++)
            for (int c = capacity; c >= 0; c--) {
                int profit1 = 0, profit2 = 0;
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[c - weights[i]];
                profit2 = dp[c];
                dp[c] = Math.max(profit1, profit2);
            }
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        System.out.println(solveKnapsackBottomUpOptimized(weights, profits, 7));
        System.out.println(solveKnapsackBottomUpOptimized(weights, profits, 6));
    }
}
