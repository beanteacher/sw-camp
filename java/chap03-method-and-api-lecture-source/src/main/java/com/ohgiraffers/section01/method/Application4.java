package com.ohgiraffers.section01.method;

public class Application4 {
    public static void main(String[] args) {
        /* 메소드 전달 인자(argument)와 매개변수(parameter)에 대해 이해하고 메소드 호출 시 사용할 수 있다. */

        Application4 app4 = new Application4();
        app4.testMethod("홍길동", 20, '남');
//        app4.testMethod(20, "홍길동", '남');


    }

    public void testMethod(String name, int age, final char gender){
        /* 매개변수도 일종의 지역변수이다. final 키워드도 사용 가능하다.
        * 단, 상수 네이밍 규칙을 선택적으로 따르는 경향이 있다. */
//        name = "홍길동";
//        age = 20;
//        gender = 'M';
        System.out.println("당신의 이름은 " + name + "이고, 나이는 "
                + age + "세 이며, 성별은 " + gender + "입니다.");

        /* void 메소드의 경우 컴파일러가 자동으로 추가해주므로 명시적 작성이 필요 없다.*/
        return;

//        System.out.println("출력"); -> return이 명시적으로 작성 된 이후 명령문을 작성할 수 없다.
    }


}
