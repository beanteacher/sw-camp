package com.ohgiraffers.section03.increment;

public class Application1 {
    public static void main(String[] args) {
        /* 증감 연산자에 대해 이해하고 활용할 수 있다. */

        int num = 20;
        num++;  // 1 증가
        System.out.println(num);
        ++num;  // 1 증가
        System.out.println(num);
        num--;  // 1 감소
        System.out.println(num);
        --num;  // 1 감소
        System.out.println(num);

        /* 다른 연산자와 함께 증감 연산자를 사용하는 경우
        * 후위 연산은 다른 연산이 수행 된 후 마지막으로 수행된다. */
        int firstNum = 20;
        int result1 = firstNum++ * 3;
        System.out.println("result1 = " + result1);
        System.out.println("firstNum = " + firstNum);

        int secondNum = 20;
        int result2 = ++secondNum * 3;
        System.out.println("result2 = " + result2);
        System.out.println("secondNum = " + secondNum);

    }
}
