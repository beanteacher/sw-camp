package com.ohgiraffers.section02.additional;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

/* JUnit에서 제공하는 메소드 관련 추가 어노테이션을 사용할 수 있다. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdditionalAnnotationTests {

    @Disabled
    @Test
    void testIgnore() {
        System.out.println("testIgnore");
    }

    @Disabled
    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void testTimeout() {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("testTimeout");
    }

    @Test
    @Order(1)
    void testFirst() {
        System.out.println("testFirst");
    }

    @Test
    @Order(3)
    void testThird() {
        System.out.println("testThird");
    }

    @Test
    @Order(2)
    void testSecond() {
        System.out.println("testSecond");
    }

    @RepeatedTest(10)
    void testRepeated() {
        System.out.println("testRepeated");
    }

}
