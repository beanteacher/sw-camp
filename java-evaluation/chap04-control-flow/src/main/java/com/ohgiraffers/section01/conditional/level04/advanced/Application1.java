package com.ohgiraffers.section01.conditional.level04.advanced;

import java.util.Scanner;

public class Application1 {

    /* 국어, 영어, 수학 점수를 입력받아
     * 평균 점수가 60점 이상이면서 각 과목이 40점 이상인 조건이 만족하면 "합격입니다!" 를 출력하세요,
     * 단, 합격이 아닌 경우 불합격 사유가 무엇인지를 모두 출력해주어야 합니다.
     * 평균점수 미달인 경우 "평균점수 미달로 불합격입니다." 라고 출력하고,
   v." 출력하세요
     *
     * -- 입력 예시 --
     * 국어 점수를 입력하세요 : 60
     * 영어 점수를 입력하세요 : 30
     * 수학 점수를 입력하세요 : 20
     *
     * -- 출력 예시 --
     * 평균 점수 미달로 불합격입니다.
     * 영어 점수 미달로 불합격입니다.
     * 수학 점수 미달로 불합격입니다.
     * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("국어 점수를 입력하세요. : ");
        int kor = scanner.nextInt();
        System.out.print("영어 점수를 입력하세요. : ");
        int eng = scanner.nextInt();
        System.out.print("수학 점수를 입력하세요. : ");
        int math = scanner.nextInt();

        if (kor < 40) {
            System.out.println("국어 점수 미달로 불합격입니다.");
        } else if (eng < 40) {
            System.out.println("영어 점수 미달로 불합격입니다.");
        } else if (math < 40) {
            System.out.println("수학 점수 미달로 불합격입니다.");
        } else if ((kor+ eng + math) / 3 < 60) {
            System.out.println("평균점수 미달로 불합격입니다.");
        } else {
            System.out.println("합격입니다.");
        }
    }
}
