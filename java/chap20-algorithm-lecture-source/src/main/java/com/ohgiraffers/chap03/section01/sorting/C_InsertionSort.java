package com.ohgiraffers.chap03.section01.sorting;

import java.util.Arrays;

/* 삽입 정렬(Insertion Sort)
 *   이미 정렬된 데이터 범위에 정렬되지 않은 데이터를 적절한 위치에 삽입시켜 정렬하는 방식이다.
 *   시간복잡도는 O(n^2)이라 효율적이지는 않다.
 *   해당 위치에 있는 값을 앞의 어떤 위치에 들어갈지 훑어보며 밀어주다 원하는 위치에 넣게 된다.
 * */
public class C_InsertionSort {

    /* 문제 내용
     *   : N개의 정수가 주어졌을 때, 삽입 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램을 작성하시오.
     *
     *  예시 입력 1
     *    - 33, 39, 20, 4, 16, 24, 19, 28
     *  예시 출력 1
     *    - 4, 16, 19, 20, 24, 28, 33, 39
     *
     *  예시 입력 2
     *    - 14, 38, 5, 26, 17, 19
     *  예시 출력 2
     *    - 5, 14, 17, 19, 26, 38
     * */

    public static void solution(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.println(i + "번째 : " + Arrays.toString(arr));
            int temp = arr[i];
            int j;
            for(j = i - 1; j >= 0; j--) {
                // i 인덱스의 앞으로 탐색하면서 기준 값 보다 큰 경우 뒤로 하나씩 인덱스를 민다.
                if(arr[j] > temp) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = temp;
        }
    }
}
