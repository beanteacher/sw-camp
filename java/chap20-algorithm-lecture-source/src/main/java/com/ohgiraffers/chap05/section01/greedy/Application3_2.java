package com.ohgiraffers.chap05.section01.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Application3_2 {

    static class Time implements Comparable<Time> {
        int start;
        int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.end == o.end) return o.start - this.start;      // 종료 시간 같을 경우 시작 시간 내림차순
            else return this.end - o.end;                           // 종료 시간 다를 경우 종료 시간 오름차순
        }
    }

    public static int solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> timeList = new ArrayList<>();   // 회의를 보관할 리스트

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            timeList.add(new Time(start, end));
        }

        /* 종료 시간이 빠른 순, 종료 시간이 동일할 경우 시작 시간이 늦은 순으로
        * 회의 스케쥴을 배정한다. */

        /* 기준에 맞게 데이터 정렬 */
        Collections.sort(timeList);

        int maxCount = 0; // 회의가 배정 된 개수
        int endTime = 0; // 직전 회의가 끝난 시간을 담아 둘 변수

        /* timeList 안에 담긴 회의를 반복하며 확인 */
        for(Time time : timeList) {
            if(time.start == time.end) {
                maxCount++;
                continue;
            }
            if(time.start >= endTime) {
                maxCount++;
                endTime = time.end;
            }
        }

        /* 최대 넣을 수 있는 회의의 갯수 */
        return maxCount;
    }
}
