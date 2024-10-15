package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class B_ifElse {
    public void testSimpleIfElseStatement() {
        /* if-else 문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다. */

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 하나 입력 : ");
        int num = sc.nextInt();

        if(num % 2 == 0) {
            System.out.println("입력하신 숫자는 짝수입니다.");
        } else {
            System.out.println("입력하신 숫자는 홀수입니다.");
        }

        System.out.println("프로그램을 종료합니다.");
    }

    public void testNestedIfElseStatement() {
        /* if-else 문 중첩 사용에 대한 흐름을 이해하고 적용할 수 있다. */

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 하나 입력 : ");
        int num = sc.nextInt();

        if(num == 0) {
            System.out.println("입력하신 숫자는 0입니다.");
        } else {
            if(num % 2 == 0) {
                System.out.println("입력하신 숫자는 짝수입니다.");
            } else {
                System.out.println("입력하신 숫자는 홀수입니다.");
            }
        }

        System.out.println("프로그램을 종료합니다.");
    }















}
