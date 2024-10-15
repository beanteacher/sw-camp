package com.ohgiraffers.section02.assignment;

public class Application1 {
    public static void main(String[] args) {
        /* 대입 연산자와 산술 복합 대입 연산자를 이해하고 활용할 수 있다.*/
        int num = 12;

        // 3 증가
        num = num + 3;

        // 3 증가 (산술 복합 대입 연산자)
        num += 3;
        System.out.println("num = " + num);

        num -= 5;
        System.out.println("num = " + num);

        num *= 2;
        System.out.println("num = " + num);

        num /= 2;
        System.out.println("num = " + num);

        num %= 2;
        System.out.println("num = " + num);

        /* 주의. 산술 복합 대입 연산자의 작성 순서 */
        num =- 5;
        System.out.println("num = " + num);

    }
}
