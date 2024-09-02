package com.ohgiraffers.section04.overflow;

public class Application {
    public static void main(String[] args) {
        /* 오버 플로우에 대해 이해할 수 있다. */

        byte num1  = 127;
        System.out.println("num1 : " + num1);

        num1++; // 1 증가

        System.out.println("num1 : " + num1);

        byte num2 = -128;
        System.out.println("num2 : " + num2);

        num2--; // 1 감소

        System.out.println("num2 : " + num2);

        /* 오버 플로우, 언더 플로우는 컴파일 에러는 발생하지 않지만 최대값 최소값 범위를 고려하여 자료형을 선택해야 한다. */
        int firstNum = 1000000;
        int secondNum = 700000;
        int multi = firstNum * secondNum;
        System.out.println("multi : " + multi);

        long longMulti = (long)firstNum * secondNum;
        System.out.println("longMulti : " + longMulti);

    }
}
