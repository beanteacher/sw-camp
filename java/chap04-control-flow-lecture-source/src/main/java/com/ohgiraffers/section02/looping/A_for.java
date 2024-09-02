package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class A_for {
    public void testSimpleForStatement() {
        /* for문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다. */
        for (int i = 0; i < 10; i++) {
            System.out.println("출력  : " + i);
        }
    }

    public void testForExample() {
        /* 1 ~ 10 까지의 합계 구하기 */
        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            sum += i;
        }

        System.out.println("sum = " + sum);

    }

    public void testForExample2() {
        /* 5 ~ 10 사이의 난수를 발생시켜 1부터 발생한 난수까지의 합 구하기 */
        int sum = 0;
        int random = (int) (Math.random() * 6) + 5;

        for (int i = 1; i <= random; i++) {
            sum += i;
        }

        System.out.println("1부터 " + random + "까지의 합계 : " + sum);

    }

    public void testForExample3() {
        /* 숫자 2개를 입력 받아 작은 수에서 큰 수까지의 합계를 구한다.
        * 동일한 숫자는 입력하지 않는다는 가정으로 해결한다.
        * */
        Scanner scanner = new Scanner(System.in);
        System.out.print("첫 번째 정수 : ");
        int firstNum = scanner.nextInt();
        System.out.print("두 번째 정수 : ");
        int secondNum = scanner.nextInt();
        int sum = 0;

        /* first와 second 중 어떤 것이 작은 수이고 큰 수인지 먼저 판별한 뒤 합계를 구한다. */
        int min = 0;
        int max = 0;

        if (firstNum > secondNum) {
            max = firstNum;
            min = secondNum;
        } else {
            max = secondNum;
            min = firstNum;
        }

        for (int i = min; i <= max; i++) {
            sum += i;
        }

        System.out.println(min + "에서 " + max + "까지의 합계 : " + sum);
    }

    public void printSimpleGugudan() {
        /* 사용자가 입력하는 단의 구구단을 출력하기 */
        Scanner scanner = new Scanner(System.in);
        System.out.print("출력할 구구단의 단 수 : ");
        int dan = scanner.nextInt();

        if(dan >= 2 && dan <= 9) {
            for(int su = 1; su <= 9; su++) {
                System.out.println(dan + " * " + su + " = " + dan * su);
            }
        } else {
            System.out.println("반드시 2~9 사이의 양수를 입력하셔야 합니다.");
        }
    }

}
