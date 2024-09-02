package com.ohgiraffers.chap06.section01.dp;

public class Application2 {

    public static int solution(int n) {

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
