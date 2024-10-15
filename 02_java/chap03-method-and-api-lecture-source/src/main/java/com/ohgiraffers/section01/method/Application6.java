package com.ohgiraffers.section01.method;

public class Application6 {
    public static void main(String[] args) {

        int a = 100;
        int b = 20;

        Application6 application6 = new Application6();
        System.out.println(application6.plus(a, b));
        System.out.println(application6.minus(a, b));
        System.out.println(application6.multiply(a, b));
        System.out.println(application6.divide(a, b));

    }

    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }
}
