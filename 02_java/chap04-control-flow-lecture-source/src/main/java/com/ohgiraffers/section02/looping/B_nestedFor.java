package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTwoToNine() {

        for(int dan = 2; dan <= 9; dan++) {
            System.out.println("===== " + dan + "단 =====");
            for(int su = 1; su <= 9; su++) {
                System.out.println(dan + " * " + su + " = " + dan * su);
            }
            System.out.println();
        }

    }

    public void printStarInputRowTimes() {
        /* 입력받은 정수만큼 한 행에 '*' 5개씩 출력 */
        Scanner sc = new Scanner(System.in);
        System.out.print("출력할 행 수 입력 : ");
        int row = sc.nextInt();

        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public void printTriangleStar() {
        /* 입력받은 정수만큼 한 행에 '*' 행의 번호개씩 출력
        * 예) 5
        *  *
        *  **
        *  ***
        *  ****
        *  *****
        * */
        Scanner sc = new Scanner(System.in);
        System.out.print("출력할 행 수 입력 : ");
        int row = sc.nextInt();

        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }










}
