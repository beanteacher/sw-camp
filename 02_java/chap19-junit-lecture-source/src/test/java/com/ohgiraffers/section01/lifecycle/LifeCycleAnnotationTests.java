package com.ohgiraffers.section01.lifecycle;

import org.junit.jupiter.api.*;

/* 테스트 메소드의 실행 전 후에 동작하는 어노테이션을 사용할 수 있다. */
class LifeCycleAnnotationTests {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before Each");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after All");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after Each");
    }

    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }
}
