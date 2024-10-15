package com.ohgiraffers.section02.looping_and_branching.level04.advanced;

import java.math.BigInteger;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        /* 받은 금액을 입력 받고, 상품 가격을 입력 받아 거스름돈을 계산하는 프로그램을 작성하세요
         *
         * 단, 거스름돈은 대한민국 화폐 단위 별 필요 수량이 출력되도록 작성하고,
         * 지폐외 동전을 구분하여 단위를 표기하세요
         *
         * -- 입력 예시 --
         * 받으신 금액을 입력하세요 : 100000
         * 상품 가격을 입력하세요 : 22340
         *
         * -- 출력 예시 --
         * ============================
         * 50000원권 지폐 1장
         * 10000원권 지폐 2장
         * 5000원권 지폐 1장
         * 1000원권 지폐 2장
         * 500원권 동전 1개
         * 100원권 동전 1개
         * 50원권 동전 1개
         * 10원권 동전 1개
         * ============================
         * 거스름돈 : 77660원
         * */
        Scanner scanner = new Scanner(System.in);
        System.out.println("받으신 금액을 입력하세요 : ");
        int money = scanner.nextInt();
        System.out.println("상품 가격을 입력하세요 : ");
        int price = scanner.nextInt();
        int change = money - price;
        int temp = change;

        System.out.println("============================");
        if(temp > 50000) {
            int fiftyThousand = temp / 50000;
            temp = temp - (fiftyThousand * 50000);
            System.out.println("50000원권 지폐 " + fiftyThousand + "장");
        }
        if(temp > 10000) {
            int tenThousand = temp / 10000;
            temp = temp - (tenThousand * 10000);
            System.out.println("10000원권 지폐 " + tenThousand + "장");
        }
        if(temp > 5000) {
            int fiveThousand = temp / 5000;
            temp = temp - (fiveThousand * 5000);
            System.out.println("5000원권 지폐 " + fiveThousand + "장");
        }
        if(temp > 1000) {
            int thousand = temp / 1000;
            temp = temp - (thousand * 1000);
            System.out.println("1000원권 지폐 " + thousand + "장");
        }
        if(temp > 500) {
            int fiveHundred = temp / 500;
            temp = temp - (fiveHundred * 500);
            System.out.println("500원권 동전 " + fiveHundred + "장");
        }
        if(temp > 100) {
            int hundred = temp / 100;
            temp = temp - (hundred * 100);
            System.out.println("100원권 동전 " + hundred + "장");
        }
        if(temp > 50) {
            int fifty = temp / 50;
            temp = temp - (fifty * 50);
            System.out.println("50원권 동전 " + fifty + "장");
        }
        if(temp > 10) {
            int ten = temp / 10;
            temp = temp - (ten * 10);
            System.out.println("10원권 동전 " + ten + "장");
        }
        System.out.println("============================");
        System.out.println("거스름돈 : " + change + "원");
    }
}
