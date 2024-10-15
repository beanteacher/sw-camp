package com.ohgiraffers.chap06.section01.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Application5 {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));

        int n = Integer.parseInt(br.readLine());    // 계단의 개수

        int[] arr = new int[n + 1];   // 계단 별 점수 저장
        int[] dp = new int[n + 1];    // 최적(최대 점수 합계)의 값 누적

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 초기화
        dp[1] = arr[1];
        if(n >= 2) dp[2] = dp[1] + arr[2];

        // 점화식은 3번 계단부터 적용
        // 한 계단 전의 개념은 연달아 세번 밟을 수 없음에 유의
        for(int i = 3; i <= n; i++) {
            // 가능 상황 1. 직전 계단에서 올라오는 경우 - 연달아 밟지 않아야 하므로 i-3 -> i-1 -> i 로 이동해야 함
            // 가능 상황 2. 두 계단 전에서 올라오는 경우 - i-2 전의 상황을 고려하지 않아도 됨
            // 1번 : dp[i - 3] + arr[a - 1] vs 2번 : dp[i - 2] 를 비교해서 더 큰 값과 현재 계단의 값을 더하면
            // 최적의 값을 누적할 수 있다.
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        return dp[n];
    }
}
