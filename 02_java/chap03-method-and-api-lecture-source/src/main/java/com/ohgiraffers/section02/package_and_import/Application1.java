package com.ohgiraffers.section02.package_and_import;

public class Application1 {
    public static void main(String[] args) {
        /* 패키지에 대해 이해할 수 있다. */
        /* 클래스명은 원래 패키지명을 포함하고 있으며
        * 다른 패키지에 존재하는 클래스를 사용하는 경우 풀 클래스명(패키지명+클래스명)을 사용해야 한다.
        * */
        com.ohgiraffers.section01.method.Calculator calculator = new com.ohgiraffers.section01.method.Calculator();
        System.out.println(calculator.min(10, 20));
    }
}
