package com.ohgiraffers.section03.constant;

public class Application1 {
    public static void main(String[] args) {
        /* 상수에 대해 이해하고 사용할 수 있다. */

        /* 상수 선언 */
        final int AGE;
        AGE = 18;   //초기화
        //AGE = 19;   //한 번 초기화 한 뒤 값 재대입 불가

        /* 상수의 명명 규칙 */
        final int age; // 소문자로 작성해도 컴파일 오류는 없으나 변수와 구분하기 위해 대문자 사용

        /* 합성어의 경우 언더스코어로 네이밍 */
        final int MAX_AGE = 40;
        final int MIN_AGE = 0;
    }
}
