package com.ohgiraffers;
import java.util.*;
import java.io.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int num = Integer.parseInt(br.readLine());
//         int result = 0;
//         int repeat = 0;
//         for(int i = 1; i < num+1; i++) {
//             int sum = 0;
//             for(int j = i; j < num+1; j++) {
//                 repeat++;
//                 sum += j;
//                 if(sum >= num) {
//                     if(sum == num) {
//                         result++;
//                     }
//                     break;
//                 }
//             }
//         }
//         System.out.println(repeat);
//         System.out.print(result);
//     }
// }


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start=0, end=0; //투포인터 설정
        int sum=0, cnt=0; //sum: 합, cnt: 가지수(정답)
        int repeat = 0;
        while(start<=N) {
            while(++end<=N) { //end 증가
                repeat++;
                sum += end; //부분합을 증가
                if(sum>=N) {
                    if(sum==N) cnt++;
                    break;
                }
            }
            while(++start<=N) { //start 증가
                repeat++;
                sum -= start; //부분합을 감소
                if(sum<=N) {
                    if(sum==N) cnt++;
                    break;
                }
            }
        }
        System.out.println(repeat);
        System.out.println(cnt);
    }
}