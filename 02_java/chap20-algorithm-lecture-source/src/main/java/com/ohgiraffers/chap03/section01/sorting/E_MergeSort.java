package com.ohgiraffers.chap03.section01.sorting;

import java.util.Arrays;

public class E_MergeSort {

    public static void solution(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println("====================================");
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {

        System.out.println("병합 전 : " + Arrays.toString(arr));
        System.out.println("(" + left + ", " + right + ")");

        // temp 초기화
        for(int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int first = left, second = mid + 1, index = left;

        /* 병합에 사용할 앞의 배열의 값이 다 소진이 되거나 뒤의 배열의 값이 다 소진이 되기 전까지 반복 */
        while(first <= mid && second <= right) {
            if(temp[first] <= temp[second]) arr[index++] = temp[first++];
            else arr[index++] = temp[second++];
        }

        /* 뒤의 배열의 값이 다 소진 되지 않았을 경우는 문제가 없으나
        * 앞의 배열의 값이 다 소진 되지 않았을 경우는 arr 쪽으로 옮겨 담아 주어야 한다. */
        for(int i = 0; i <= mid - first; i++) {
            arr[index + i] = temp[first + i];
        }

        System.out.println("병합 후 : " + Arrays.toString(arr));
    }


}
