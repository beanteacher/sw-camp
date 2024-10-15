package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class D_switch {
    public void testSimpleSwitchStatement() {
        /* switch문 사용에 대한 흐름을 이해하고 적용할 수 있다. */

        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 정수 : ");
        int first  = sc.nextInt();
        System.out.print("두 번째 정수 : ");
        int second = sc.nextInt();
        System.out.print("연산 기호 입력 : ");
        char op = sc.next().charAt(0);

        int result = 0;

        switch (op) {
            case '+':
                System.out.println("더하기 연산 실행");
                result = first + second;
                break;
            case '-': result = first - second; break;
            case '*':
            case 'x':
                result = first * second; break;
            case '/': result = first / second; break;
            case '%': result = first % second; break;
        }

        System.out.println(first + " " + op + " " + second + " = " + result);
    }

    public void improveSwitchStatement() {
        /* java 14부터 적용 된 개선 된 switch 문 사용에 대한 흐름을 이해하고 적용할 수 있다. */

        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 정수 : ");
        int first  = sc.nextInt();
        System.out.print("두 번째 정수 : ");
        int second = sc.nextInt();
        System.out.print("연산 기호 입력 : ");
        char op = sc.next().charAt(0);

        /* -> 를 사용하면 break를 사용한 것과 동일하며 오히려 작성하면 오류가 발생함.
        2개 이상의 명령문을 작성해야 할 경우 {} 로 표기해야 함.
        반환 값을 리턴할 수 있음. 단, 반드시 default가 있어야만 함.
        yield 키워드 : 값을 명시적으로 리턴
        * */
        int result = switch (op) {
            case '+' -> {
                System.out.println("더하기 연산 실행");
                yield first + second;
            }
            case '-' -> first - second;
            case '*', 'x' -> first * second;
            // second가 0이면 발생할 수 있는 런타임 오류 java.lang.ArithmeticException: / by zero
            case '/' -> first / second;
            case '%' -> first % second;
            default -> 0;
        };

        System.out.println(first + " " + op + " " + second + " = " + result);
    }
}
