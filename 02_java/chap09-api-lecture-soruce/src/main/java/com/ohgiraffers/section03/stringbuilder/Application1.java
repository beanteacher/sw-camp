package com.ohgiraffers.section03.stringbuilder;

public class Application1 {
    public static void main(String[] args) {
        /* StringBuilder 인스턴스 생성 */
        StringBuilder sb = new StringBuilder("java");
        System.out.println("sb = " + sb);

        System.out.println("sb.hashCode() = " + sb.hashCode());

        /* 문자열 수정 */
        sb.append("oracle");

        System.out.println("sb = " + sb);

        /* 기존 인스턴스와 수정 후의 인스턴스가 동일한 주소 값을 가지는 것을 확인할 수 있다.
        * 즉, 문자열을 변경했다고 해서 새로운 인스턴스가 생성 된 것은 아니다.
        * */
        System.out.println("sb.hashCode() = " + sb.hashCode());
    }
}
