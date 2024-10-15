package com.ohgiraffers.section01.exception;

public class Application {
    public static void main(String[] args) throws Exception {
        ExceptionTest exceptionTest =  new ExceptionTest();

        /* 예외 처리가 강제화 된 메소드를 호출하는 경우 반드시 예외 처리가 필요하다.
        * 여기서는 throws로 다시 책임을 위임하는 처리를 했다.
        * 단, main 메소드까지 예외를 throws하면 프로그램은 비정상 종료 된다. */
        exceptionTest.checkEnoughMoney(10000, 50000);
        exceptionTest.checkEnoughMoney(50000, 10000);
        System.out.println("프로그램을 종료합니다.");
    }
}
