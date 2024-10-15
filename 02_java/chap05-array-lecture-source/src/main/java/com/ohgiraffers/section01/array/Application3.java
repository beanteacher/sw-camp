package com.ohgiraffers.section01.array;

public class Application3 {
    public static void main(String[] args) {
        /* 배열에 초기화 되는 자료형별 기본 값을 이해할 수 있다. */

        /* 지역 변수(stack 영역에 할당)는 반드시 초기화해야만 접근 가능하지만
        * heap 영역에 할당 될 경우 초기값이 설정 된다.
        * 정수 : 0
        * 실수 : 0.0
        * 논리 : false
        * 문자 : \u0000
        * 참조 : null
        * */

        int num;
//        System.out.println(num);

        int[] iarr = new int[10];
        for (int i = 0; i < iarr.length; i++) {
            System.out.println("iarr[" + i + "] = " + iarr[i]);
        }

        /* 기본 값 외의 값으로 초기화하면서 배열을 생성하고 싶을 경우 블럭을 사용한다. */
        int[] iarr2 = {11, 22, 33, 44, 55};
        for (int i = 0; i < iarr2.length; i++) {
            System.out.println("iarr2[" + i + "] = " + iarr2[i]);
        }

        /* 문자열도 배열로 사용할 수 있다. */
        String[] sarr = {"A", "B", "C", "D", "E", "F"};
        for (int i = 0; i < sarr.length; i++) {
            System.out.println("sarr[" + i + "] = " + sarr[i]);
        }

    }
}
