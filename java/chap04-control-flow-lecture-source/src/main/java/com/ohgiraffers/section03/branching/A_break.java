package com.ohgiraffers.section03.branching;

public class A_break {

    public void testSimpleBreakStatement() {
        /* break 사용에 대한 흐름을 이해하고 적용할 수 있다. */

        int sum = 0;
        int i = 1;
        while(true) {
            sum += i++;
            if(i > 100) break;
        }

        System.out.println("sum = " + sum);

    }

    public void testSimpleBreakStatement2() {
        /* 중첩 반복문 내 break 사용에 대한 흐름을 이해하고 적용할 수 있다.
        * break는 모든 반복문을 종료하는 것이 아니라 가장 인접한 반복문의 실행을 종료한다. */
        for(int dan = 2; dan <= 9; dan++) {
            System.out.println("===== " + dan + "단 =====");
            for(int su = 1; su <= 9; su++) {
                if(su > 5) break;
                System.out.println(dan + " * " + su + " = " + dan * su);
            }
            System.out.println();
        }
    }

    public void testJumpBreak() {
        /* 중첩 반복문 내에서 break 사용시 jump(goto)에 대한 흐름을 이해할 수 있다. */
        label:
        for(;;) {
            for(int i = 0; i < 10; i++) {
                System.out.println(i);
                if(i == 3) break label;
            }
        }
    }
























}
