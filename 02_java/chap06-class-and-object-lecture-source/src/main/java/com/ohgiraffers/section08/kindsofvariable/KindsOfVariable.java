package com.ohgiraffers.section08.kindsofvariable;

public class KindsOfVariable {
    /* 다양한 변수를 이해하고 사용할 수 있다. */

    private int globalNum;              // 전역변수, 인스턴스 변수 -> 인스턴스 생성 시
    private static int staticNum;       // 전역변수, 클래스 변수 -> 프로그램 실행 시

    public void method(int num) {   // 매개 변수 (일종의 지역 변수)

        int localNum;   // 지역 변수

        /* 매개변수는 호출 시 값이 전달 되어 초기화 되지만 지역 변수는 선언 외에 사용을 위해서는
        * 반드시 초기화 되어야만 한다. */
        System.out.println(num);
//        System.out.println(localNum);

        System.out.println(globalNum);
        System.out.println(staticNum);

    }

    public void method2() {
        /* 지역 변수는 해당 지역(블럭 내)에서만 사용이 가능하며
        * 전역 변수는 클래스 내의 모든 영역에서 사용할 수 있다. */
//        System.out.println(localNum);
        System.out.println(globalNum);
        System.out.println(staticNum);
    }
}
