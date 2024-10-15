package com.ohgiraffers.section03.grammer;

public class Application1 {
    public static void main(String[] args) {
        /* Enum type 메소드 */
        /* 1. values() : 열거 타입의 모든 값을 배열로 반환 */
        for(EnumType enumType : EnumType.values()) {
            System.out.println("type = " + enumType);
        }

        /* 2. valueOf() : 해당 이름을 가진 열거 타입 상수 반환 */
        for(EnumType enumType : EnumType.values()) {
            if(enumType == EnumType.valueOf("JAVA"))
                System.out.println("type = " + enumType);
        }

        /* 3. ordinal() : 열거 타입의 상수의 순서를 리턴 */
        for(EnumType enumType : EnumType.values()) {
            System.out.println("ordinal = " + enumType.ordinal());
        }

        System.out.println(EnumType.ORACLE.ordinal());

        /* 4. name() : 열거 타입의 문자열 리턴 */
        System.out.println("name = " + EnumType.ORACLE.name());
        /* 기본적으로는 toString()도 열거 타입의 문자열을 리턴하지만 필요에 따라 오버라이딩 해서 사용 가능하다. */
        System.out.println("name = " + EnumType.ORACLE.toString());
        System.out.println("name = " + EnumType.ORACLE);
    }
}
