package com.ohgiraffers.section02.demensional;

public class Application3 {
    public static void main(String[] args) {
        /* 2차원 배열의 선언과 할당 및 초기화를 동시에 할 수 있다. */

        /* 정변 배열 */
        int[][] iarr = { {1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15} };

        /* 가변 배열 */
        int[][] iarr2 = { {1,2,3}, {4,5}, {6,7,8,9,10} };

        /* 미리 할당 된 배열을 이용하는 방식 */
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 10};
        int[][] iarr3 = {arr1, arr2};
        

    }
}
