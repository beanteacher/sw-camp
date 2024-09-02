package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application2 {
    public static void main(String[] args) {
        /* 사용자 정의 예외 클래스를 사용할 수 있다. */
        ExceptionTest exceptionTest = new ExceptionTest();

        try {
            /* 상품 가격보다 가진 돈이 적은 경우 */
//            exceptionTest.checkEnoughMoney(50000, 30000);

            /* 상품 가격이 음수인 경우 */
//            exceptionTest.checkEnoughMoney(-50000, 30000);

            /* 가진 돈이 음수인 경우 */
//            exceptionTest.checkEnoughMoney(50000, -30000);

            /* 정상적으로 구매 가능한 돈을 가진 경우 */
            exceptionTest.checkEnoughMoney(30000, 50000);

            /* | : 동일한 레벨의 다른 타입의 예외를 하나의 catch 블럭에서 처리할 수 있다.
            * 단, 상위 타입의 Exception과 하위 타입의 Exception이 함께 서술 될 수 없다.
            * EX : Exception | NotEnoughMoneyException (X) , NegativeException | PriceNegativeException (X) */
        } catch (PriceNegativeException | MoneyNegativeException e) {

        } catch (NotEnoughMoneyException e) {}

        System.out.println("프로그램을 종료합니다.");
    }
}
