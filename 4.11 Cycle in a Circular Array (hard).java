package com.solution;

// Cycle in a Circular Array.
public class Main {
    public static boolean hasLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isForward = nums[i] > 0;
            int slow = i, fast = i;
            do {
                slow = nextIndex(nums, slow, isForward);
                fast = nextIndex(nums, fast, isForward);
                if (fast != -1) {
                    fast = nextIndex(nums, fast, isForward);
                }
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && fast != -1 && slow == fast) return true;
        }
        return false;
    }

    private static int nextIndex(int[] nums, int cur, boolean isForward) {
        if (isForward != (nums[cur] > 0)) return -1;
        int nextIndex = (nums[cur] + cur) % nums.length;
        if (nextIndex < 0) nextIndex += nums.length;
        if (nextIndex == cur) return -1;
        return nextIndex;
    }

    public static void main(String[] args) {
        System.out.println(hasLoop(new int[]{1, 2, -1, 2, 2}));
        System.out.println(hasLoop(new int[]{2, 2, -1, 2}));
        System.out.println(hasLoop(new int[]{2, 1, -1, -2}));
    }
}
