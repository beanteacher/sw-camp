package com.ohgiraffers.section03.copy;

public class Application1 {
    public static void main(String[] args) {
        /* 배열의 복사 개념 중 얕은 복사에 대해 이해할 수 있다. */

        /* 원본 배열 */
        int[] originArr = {1, 2, 3, 4, 5};

        /* 얕은 복사 */
        int[] copyArr = originArr;

        System.out.println(originArr.hashCode());
        System.out.println(copyArr.hashCode());

        originArr[2] = 100;

        for (int i = 0; i < originArr.length; i++) {
            System.out.println(originArr[i]);
        }

        for (int i = 0; i < copyArr.length; i++) {
            System.out.println(copyArr[i]);
        }
    }
}
