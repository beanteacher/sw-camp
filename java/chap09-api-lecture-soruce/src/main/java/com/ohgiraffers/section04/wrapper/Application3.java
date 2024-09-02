package com.ohgiraffers.section04.wrapper;

public class Application3 {
    public static void main(String[] args) {
        /* parsing과 반대로 기본 자료형 값을 문자열로 변경하는 경우도 필요하다. */
        String b = Byte.valueOf((byte)1).toString();
        String s = Short.valueOf((short)2).toString();
        String i = Integer.valueOf(3).toString();
        String l = Long.valueOf(4).toString();
        String f = Float.valueOf(5).toString();
        String d = Double.valueOf(6).toString();
        String bl = Boolean.valueOf(true).toString();
        String c = Character.valueOf('A').toString();
        /* String 클래스의 valueOf */
        String str = String.valueOf(10);
        /* 문자열 합치기를 이용해 변환 */
        String str2 = 123 + "";

    }
}
