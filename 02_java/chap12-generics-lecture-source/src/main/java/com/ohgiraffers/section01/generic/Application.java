package com.ohgiraffers.section01.generic;

public class Application {
    public static void main(String[] args) {
        /* generic : 사전적 의미로는 일반적인. 자바에서 제네릭은 데이터 타입을 일반화 한다는 의미이다. */

        /* 제네릭 프로그래밍
        * 데이터 형식에 의존 없이 여러 다른 데이터 타입을 가질 수 있는 기술로 재사용성을 높일 수 있다.
        * 컴파일 시 미리 타입 검사를 하여 객체의 타입 안정성을 높이고,
        * 반환 값에 대한 타입 변환 및 타입 검사에 들어가는 코드도 생략이 가능해진다.
        * */

        /* 타입을 Integer로 하여 인스턴스 생성 */
        GenericTest<Integer> gt1 = new GenericTest<>();
        gt1.setValue(10);
//        gt1.setValue("Hello World!");
        Integer num = gt1.getValue();

        /* 타입을 String으로 하여 인스턴스 생성 */
        GenericTest<String> gt2 = new GenericTest<>();
        gt2.setValue("Hello");
//        gt2.setValue(10);
        String str = gt2.getValue();

        /* 제네릭 없이 인스턴스 생성 */
        GenericTest gt3 = new GenericTest();
        gt3.setValue("Hello");
        gt3.setValue(10);
        Integer num2 = (Integer) gt3.getValue();

    }
}
