package com.ohgiraffers.section01.user_type;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        /* 사용자 정의 자료형 사용하기 */

        /* 변수 선언 및 객체 생성
        * 클래스명 변수명 = new 클래스명() <- 객체(instance)를 생성하는 구문
        * 사용자 정의 자료형인 클래스를 사용하기 위해서는 new 연산자로 heap 영역에 할당을 해야한다.
        * 객체를 생성하게 되면 클래스에 정의한 필드(전역변수)와 메소드 대로 객체가 생성 된다.
        * */
        Member member = new Member();

        /* 필드에 접근하기 위해 레퍼런스변수명.필드명 으로 접근한다.
        * '.'은 참조 연산자라고 하는데, 레퍼런스 변수가 참조하는 주소로 접근한다는 의미를 가진다.
        * heap 영역은 기본적으로 JVM 초기값으로 초기화 된다. */
        System.out.println("member.id = " + member.id);
        System.out.println("member.pwd = " + member.pwd);
        System.out.println("member.name = " + member.name);
        System.out.println("member.age = " + member.age);
        System.out.println("member.gender = " + member.gender);
        System.out.println("member.hobby = " + member.hobby);

        member.id = "user01";
        member.pwd = "pass01";
        member.name = "홍길동";
        member.age = 18;
        member.gender = 'M';
        member.hobby = new String[] {"축구", "야구", "코딩"};

        System.out.println("member.id = " + member.id);
        System.out.println("member.pwd = " + member.pwd);
        System.out.println("member.name = " + member.name);
        System.out.println("member.age = " + member.age);
        System.out.println("member.gender = " + member.gender);
        System.out.println("member.hobby = " + Arrays.toString(member.hobby));

    }
}
