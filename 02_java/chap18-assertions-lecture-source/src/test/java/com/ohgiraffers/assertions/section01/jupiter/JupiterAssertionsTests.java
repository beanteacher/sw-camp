package com.ohgiraffers.assertions.section01.jupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/* JUnit5에서 제공하는 Assertions 에 있는 메소드에 대해 이해하고 활용할 수 있다. */
class JupiterAssertionsTests {

    /* 1. assertEquals : 예상 값과 실제 값의 일치 여부를 동일성으로 판단 */
    @Test
    void testAssertEqauls() {
        /* given */
        int firstNum = 10;
        int secondNum = 20;
        int expectedNum = 29;

        /* when */
        Calculator calculator = new Calculator();
        int result = calculator.plus(firstNum, secondNum);

        /* then */
//        Assertions.assertEquals(expectedNum, result);
//        Assertions.assertEquals(expectedNum, result, 1); // 오차 범위
        Assertions.assertNotEquals(expectedNum, result);
    }

    /* 2. assertNull */
    @Test
    @DisplayName("null 여부 테스트")
    void testAssertNull() {
//        String str = null;
//        Assertions.assertNull(str);

        String str = "hello world!";
        Assertions.assertNotNull(str);
    }

    /* 3. assertAll */
    @Test
    @DisplayName("동시에 여러 가지 값에 대한 검증을 수행하는 테스트")
    void testAssertAll() {

        String firstName = "길동";
        String lastName = "홍";

        Person person = new Person(firstName, lastName);

        Assertions.assertAll(
                "그룹화 된 테스트의 이름(테스트 실패시 보여지는 부분)",
                ()-> Assertions.assertEquals(firstName, person.getFirstName(), ()-> "firstName이 잘못됨"),
                ()-> Assertions.assertEquals(lastName, person.getLastName(), ()-> "lastName이 잘못됨")
        );
    }

    /* 4. assertThrows/assertInstanceOf */
    @Test
    @DisplayName("void 메소드의 경우 exception이 발생하는지 테스트")
    void testAssertThrow() {
        int firstNum = 10;
        int secondNum = 0;

        NumberValidation validator = new NumberValidation();
        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.checkDividableNumbers(firstNum, secondNum)
        );

        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(IllegalArgumentException.class, exception, () -> "예외 타입 불일치"),
                () -> Assertions.assertEquals("0으로 나눌 수 없습니다.", exception.getMessage(), () -> "예외 메세지 불일치")
        );


    }

















}
