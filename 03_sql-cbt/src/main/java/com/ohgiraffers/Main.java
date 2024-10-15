package com.ohgiraffers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int stringLength = Integer.parseInt(st.nextToken());
        int passwordLength = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        st = new StringTokenizer(br.readLine());
        int aCount = Integer.parseInt(st.nextToken());
        int cCount = Integer.parseInt(st.nextToken());
        int gCount = Integer.parseInt(st.nextToken());
        int tCount = Integer.parseInt(st.nextToken());

        int result = 0;

        for(int i = 0; i < stringLength - passwordLength + 1; i++) {
            String substr = str.substring(i, passwordLength+i);
            if(selectCount(substr, "A", aCount) && selectCount(substr, "C", cCount)
            && selectCount(substr, "G", gCount) && selectCount(substr, "T", tCount)) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static boolean selectCount(String substr, String ch, int chCount) {
        String[] arr = substr.split("");

        int count = 0;

        for (String s : arr) {
            if (s.equals(ch)) {
                count++;
            }
        }
        return count >= chCount;
    }
}