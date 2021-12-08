package org.example.leetcode;

/**
 * No.509 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 */
public class Fib {
    public int fib(int n) {
        if (n==0) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for (int index = 2; index <= n; index++) {
            dp[index] = dp[index-1]+dp[index-2];
        }
        return dp[n];
    }
}