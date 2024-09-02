package com.ohgiraffers.level01.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application2 {
    public static void main(String[] args) throws IOException {
        /* ----- 입력 예시 -----
         *
         * 문자열 입력 : hello world Hello everyone! 안녕하세요 반갑습니다
         *
         * ----- 출력 예시 -----
         *
         * ===== 단어 빈도 =====
         * hello: 2
         * world: 1
         * everyone: 1
         * 가장 빈도 높은 단어 : hello (2 번)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine().toLowerCase().replaceAll("[^a-z\\s]", "");
        String[] inputArr = input.split(" ");

        int[] countArr = new int[inputArr.length];

        for(int i = 0; i < inputArr.length; i++) {
            countArr[i] = 1;
            for(int j = 0; j < i; j++) {
                if(inputArr[i].equals(inputArr[j])) {
                    countArr[j] = countArr[j] + 1;
                    countArr[i] = countArr[i] - 1;
                }
            }
        }

        int max = 0;
        String maxStr = "";

        for(int i = 0; i < countArr.length; i++) {

            if(countArr[i] != 0) {
                if(countArr[i] > max) {
                    max = countArr[i];
                    maxStr = inputArr[i];
                }
                sb.append(inputArr[i]).append(" : ").append(countArr[i]).append("\r\n");
            }
        }
        sb.append("가장 빈도 높은 단어 : ").append(maxStr).append("(").append(max).append("번)");

        System.out.println(sb);
    }
}
