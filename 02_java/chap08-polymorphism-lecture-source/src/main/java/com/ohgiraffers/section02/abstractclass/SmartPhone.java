package com.ohgiraffers.section02.abstractclass;

/* 추상 클래스를 상속 받을 경우 추상 메소드를 반드시 오버라이딩 해야 한다. (오버라이딩 강제화) */
public class SmartPhone extends Product {
    @Override
    public void abstMethod() {
        System.out.println("Product 클래스의 abstMethod 오버라이딩 한 메소드 호출");
    }

    /* 추가적 메소드 작성 */
    public void printSmartPhone() {
        System.out.println("SmartPhone 클래스의 printSmartPhone 메소드 호출");
    }
}