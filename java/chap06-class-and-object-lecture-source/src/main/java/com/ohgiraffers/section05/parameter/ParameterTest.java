package com.ohgiraffers.section05.parameter;

import java.util.Arrays;

public class ParameterTest {

    /* 1. 기본 자료형 */
    public void testPrimaryTypeParameter(int num) {
        num += 10;
        System.out.println("testPrimaryTypeParameter num = " + num);
    }

    /* 2. 기본 자료형 배열 */
    public void testPrimaryTypeArrayParameter(int[] iarr) {
        iarr[0] = 99;
        System.out.println("testPrimaryTypeArrayParameter iarr[0] = " + iarr[0]);
    }

    /* 3. 클래스 자료형 */
    public void testClassTypeParameter(Rectangle rectangle) {
        rectangle.setWidth(32.5);
        rectangle.setHeight(42.5);
        System.out.println("testClassTypeParameter rectangle.getWidth() = " + rectangle.getWidth());
        System.out.println("testClassTypeParameter rectangle.getHeight() = " + rectangle.getHeight());
    }

    /* 5. 가변 인자
    * 인자로 전달하는 값의 개수가 정해져 있지 않은 경우 활용
    * 매개변수가 몇 개 전달 될 지 알 수 없으므로 반드시 매개변수 목록의 가장 뒤에 작성해야 함
    * */
    public void testVariableLengthArrayParameter(String name, String... hobby) {
        System.out.println("이름 : " + name);
        System.out.println("취미의 개수 : "  + hobby.length);
        System.out.println("취미 : " + Arrays.toString(hobby));
    }

    /* 가변인자를 사용한 메소드를 오버로딩하면 모호해지는 문제가 발생할 수 있음. */
//    public void testVariableLengthArrayParameter(String... hobby) {}










}
