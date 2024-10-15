package com.ohgiraffers.chap05.section01.greedy;

public class Application1 {

    public static int solution(int n) {

        /* 3키로와 5키로 봉지로 가져갈 수 있는 최소 봉지 수 */
        int count = 0;

        while(true) {
            /* 5키로 봉지로 모두 가져갈 수 있다면? */
            if(n % 5 == 0) {
                return n / 5 + count;
            } else if(n < 0) {  // 3 or 5 키로 봉지로 해결이 안되는 상황
                return -1;
            } else if(n == 0) { // 3키로 봉지로만 해결 되는 상황
                return count;
            }

            /* 5키로 봉지로 모두 가져갈 수 없다면 3키로 봉지 1개를 사용한다. */
            n = n - 3;
            count++;
        }
    }
}
