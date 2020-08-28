package com.solution;

// Return all structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’.
public class Main {
    public static int countUniqueTrees(int n) {
        if (n <= 1) return 1;
        int count = 0;
        for (int i = 1; i <= n; i++)
            count += countUniqueTrees(i - 1) * countUniqueTrees(n - i);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countUniqueTrees(2));
        System.out.println(countUniqueTrees(3));
    }
}
