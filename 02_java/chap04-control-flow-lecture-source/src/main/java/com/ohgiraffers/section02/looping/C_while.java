package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class C_while {

    public void testSimpleWhileStatement(){
        /* while 단독 사용에 대한 흐름을 이해하고 적용할 수 있다. */

        // 초기식
        int i = 1;

        while(i <= 10) {    // 조건식
            System.out.println("출력 확인 : " + i);
            i++;    // 증감식
        }
    }

    public void testWhileExample() {
        /* while 문을 이용한 구구단 출력 (중첩 사용) */
        int dan = 2;
        while(dan < 10) {
            int su = 1;
            while(su < 10) {
                System.out.println(dan + " * " + su + " = " + dan * su);
                su++;
            }
            dan++;
        }
    }

    public void testWhileExample2() {
        /* 키보드로 문자열을 입력 받아 반복적으로 출력하기
        * 단, "exit"가 입력 되면 반복을 종료한다. */
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while(!str.equals("exit")) {
            System.out.print("문자열 입력 : ");
            str = scanner.nextLine();
            System.out.println("입력 받은 문자열 : " + str);
        }
    }

    public void testSimpleDoWhileStatement() {
        do {
            System.out.println("최초로 한번은 무조건 동작함");
        } while(false);
    }

}
