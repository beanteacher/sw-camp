package com.ohgiraffers.level01.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application1 {
    public static void main(String[] args) throws IOException {
        /* ----- 입력 예시 -----
         *
         * 문자열 입력 : I will be a good developer.
         *
         * ----- 출력 예시 -----
         *
         * 변환된 문자열: I Will Be A Good Developer.
         * 총 단어 개수: 6
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String strArr[] = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].substring(0, 1).toUpperCase() + strArr[i].substring(1).toLowerCase() + " ";
            sb.append(strArr[i]);
        }

        System.out.println(sb);
    }
}
