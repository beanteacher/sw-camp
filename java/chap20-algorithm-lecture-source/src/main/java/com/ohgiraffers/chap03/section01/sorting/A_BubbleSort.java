package com.ohgiraffers.chap03.section01.sorting;

import java.util.Arrays;

/*  버블 정렬(Bubble Sort)
 *   두 인접한 데이터의 크기를 비교해 정렬하는 방법이다.
 *   버블의 모든 요소에 대해 반복하면서, 각 반복마다 가장 큰(작은) 요소가 배열의 끝으로 "버블링(이동)" 된다.
 *   시간 복잡도는 O(n^2)이라 효율적이지는 않다.
 * */
public class A_BubbleSort {
    /*  문제 내용
     *   : N개의 정수가 주어졌을 때, 버블 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램을 작성하시오.
     *
     *   예시 입력 1
     *     - 34, 23, 5, 24, 1, 9, 12
     *   예시 출력 1
     *     - 1, 5, 9, 12, 23, 24, 34
     *
     *   예시 입력 2
     *     - 40, 47, 38, 8, 33, 35
     *   예시 출력 2
     *     - 8, 33, 35, 38, 40, 47
     * */

    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println((i + 1) + "번째 : " + Arrays.toString(arr));
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 만약 j 인덱스가 j+1 값보다 크다면 오름차순 기준에 맞지 않으므로 swap 필요
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
