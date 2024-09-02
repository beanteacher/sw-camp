package com.ohgiraffers.section01.method;

public class Application8 {
    public static void main(String[] args) {
        /* 다른 클래스에 작성 된 메소드를 호출할 수 있다.*/

        /* 1. non-static method 호출 */
        Calculator calculator = new Calculator();
        int min = calculator.min(10, 20);
        System.out.println(min);
        /* 2. static method 호출 */
        int max = Calculator.max(10, 20);
        System.out.println(max);
        /* 주의. static 메소드를 non-static 메소드처럼 호출할 수 있으나 권장하지 않는다. */
        System.out.println(calculator.max(10, 20));

    }
}
