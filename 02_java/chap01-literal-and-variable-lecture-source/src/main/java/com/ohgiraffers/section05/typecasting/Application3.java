package com.ohgiraffers.section05.typecasting;

public class Application3 {
    public static void main(String[] args) {
        /* 주의. int 미만의 연산의 처리 결과는 int */
        byte byteNum1 = 1;
        byte byteNum2 = 2;
//        byte result = byteNum1 + byteNum2;
        int result = byteNum1 + byteNum2;

        short shortNum1 = 1;
        short shortNum2 = 2;
//        short result2 = shortNum1 + shortNum2;
        int result2 = shortNum1 + shortNum2;
    }
}
