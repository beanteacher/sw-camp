package com.ohgiraffers.chap03.section01.sorting;

import java.util.Arrays;

/* 선택 정렬(Selection Sort)
 *   대상 데이터에서 최대나 최소 데이터를 찾아 맨 앞(또는 맨 뒤)와 교환하는 방법이다.
 *   배열의 모든 요소에 대해 반복한다.
 *   시간 복잡도는 역시 O(n^2)이라 효율적이지는 않다.
 * */
public class B_SelectionSort {
    /*  문제 내용
     *   : N개의 정수가 주어졌을 때, 선택 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램을 작성하시오.
     *
     * 예시 입력 1
     *    - 34, 23, 5, 24, 1, 9, 12
     *  예시 출력 1
     *    - 1, 5, 9, 12, 23, 24, 34
     *
     *  예시 입력 2
     *    - 40, 47, 38, 8, 33, 35
     *  예시 출력 2
     *    - 8, 33, 35, 38, 40, 47
     * */

    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println((i + 1) + "번째 : " + Arrays.toString(arr));
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 기준 인덱스가 보유한 값이 탐색 중인 인덱스가 보유한 값보다 크다면
                // 오름차순 기준에 맞지 않으므로 minIndex 변경
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // minIndex가 판단 되었으므로 해당 값으로 swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
