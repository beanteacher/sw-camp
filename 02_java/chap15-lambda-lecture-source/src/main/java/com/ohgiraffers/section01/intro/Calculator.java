package com.ohgiraffers.section01.intro;
/* 내부에 하나의 추상 메소드가 선언 된 인터페이스만 람다식의 타깃이 될 수 있다.
* => 함수적 인터페이스(Functional Interface)라고 하며 어노테이션으로 체크할 수 있다. */
@FunctionalInterface
public interface Calculator {

    int sumTwoNumber(int a, int b);

//    int minusTwoNumber(int a, int b);

}
