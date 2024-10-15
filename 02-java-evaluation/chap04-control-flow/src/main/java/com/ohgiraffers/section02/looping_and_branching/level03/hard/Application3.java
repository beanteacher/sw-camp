package com.ohgiraffers.section02.looping_and_branching.level03.hard;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application3 {
    public static void main(String[] args) {
        /* 문자열을 하나 입력 받고, 검색할 문자를 입력 하여
         * 입력받은 문자열에서 검색할 문자가 몇 개 포함되어 있는지를 출력하는 프로그램을 만드세요
         *
         * 단, 문자열에 영문자가 아닌 문자가 섞여 있는 경우에는
         * 검색할 문자를 입력받지 않고 "영문자가 아닌 문자가 포함되어 있습니다." 출력 후 프로그램을 종료하세요
         *
         * 또한 일치하는 문자의 경우 대소문자를 구분합니다.
         *
         * -- 프로그램 예시 --
         *
         * -- 정상 동작의 경우 --
         * -- 입력 예시 --
         * 문자열 입력 : apple
         * 문자 입력 : p
         *
         * -- 출력 예시 --
         * 포함된 갯수 : 2개
         *
         * --------------------
         * -- 영문자가 아닌 문자 포함된 경우 --
         * -- 입력 예시 --
         * 문자열 입력 : app2le
         *
         * -- 출력 예시 --
         * 영문자가 아닌 문자가 포함되어 있습니다.
         * */

        Scanner scanner = new Scanner(System.in);
        System.out.print("문자열 입력 : ");

        String inputStr = scanner.nextLine();
        System.out.print("문자 입력 : ");

        char inputChar = scanner.nextLine().charAt(0);
        int cnt = 0;

        String regex = "^[A-Za-z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);

        if(!matcher.matches()) {
            System.out.println("영문자가 아닌 문자가 포함되어 있습니다.");
            return;
        }

        for(int i = 0; i < inputStr.length(); i++) {

            if(inputStr.charAt(i) == inputChar) {
                cnt++;
            }
        }

        System.out.println("포함된 갯수 : " + cnt);
    }
}
