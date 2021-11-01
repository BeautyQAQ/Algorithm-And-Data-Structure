package org.example.leetCode;

/**
 * No.209 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    count = Math.min(count, j - i + 1);
                    break;
                }
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
