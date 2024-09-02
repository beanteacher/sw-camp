package com.ohgiraffers.level01.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Application1 {

    /*
    * 학생 성적 : 100
    추가 입력하려면 y : y
    학생 성적 : 95
    추가 입력하려면 y : Y
    학생 성적 : 66
    추가 입력하려면 y : y
    학생 성적 : 79
    추가 입력하려면 y : n
    학생 인원 : 4
    평균 점수 : 85.0
    * */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            ArrayList<Integer> scoreList = new ArrayList<>();

            do {
                System.out.print("학생 성적 : ");
                scoreList.add(Integer.parseInt(br.readLine()));

                System.out.print("추가 입력하려면 y : ");
            } while (br.readLine().toUpperCase().charAt(0) == 89);

            System.out.print("학생 인원 : ");
            int studentCount = Integer.parseInt(br.readLine());
            int sum = 0;
            for(int score : scoreList) {
                sum += score;
            }

            System.out.print("평균 점수 : " + sum/studentCount);
        } catch (IOException e) {

        }
    }
}
