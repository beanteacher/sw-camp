package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.stream.IntStream;

public class Application1 {
    public static void main(String[] args) {
        /* 스트림의 중계 연산 중 하나인 filter에 대해 이해하고 사용할 수 있다.
        * filter : 스트림에서 특정 데이터만 걸러내는 메소드로 매개변수로 Predicate (boolean을 반환) 인터페이스 형식의 람다식 전달한다.
        * */

        IntStream intStream = IntStream.range(0, 10);
        intStream.filter(i -> i % 2 == 0).forEach(System.out::println);
    }
}
