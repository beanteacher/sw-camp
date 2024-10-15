package com.ohgiraffers.chap03.section01.sorting;

import java.util.Arrays;

/* 퀵 정렬(Quick Sort)
 *   기준값(pivot)을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해서 정렬하는 것으로
 *   병합 알고리즘과 함께 실제 정렬 알고리즘으로 많이 활용되고 있다.
 *   시간 복잡도는 O(nlogn)이지만 최악의 경우는 O(n^2)이다.
 * */
public class D_QuickSort {

    public static void solution(int[] arr) {
        System.out.println("원본 : " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        int partition = process(arr, low, high);
        if(low < partition - 1) quickSort(arr, low, partition - 1);
        if(partition < high) quickSort(arr, partition, high);

    }
    /* low는 왼쪽에서부터 진행, high는 오른쪽에서부터 진행하면서
    pivot 기준으로 맞지 않는 값을 swap 하는 메소드 */
    private static int process(int[] arr, int low, int high) {

        int pivot = arr[(low + high) / 2];

        System.out.println("process 전의 low : " + low + ", high : " + high);

        while(low <= high) {

            while(arr[low] < pivot) low++;
            while(arr[high] > pivot) high--;

            if(low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }

        System.out.println("process 후 array : " + Arrays.toString(arr));
        System.out.println("===============================================");

        return low;
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
