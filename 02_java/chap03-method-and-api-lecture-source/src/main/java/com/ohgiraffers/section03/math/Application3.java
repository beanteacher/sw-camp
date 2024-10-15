package com.ohgiraffers.section03.math;

import java.util.Random;

public class Application3 {
    public static void main(String[] args) {
        /* java.util.Random */
        Random random = new Random();

        /* 1. 0 ~ 9 범위의 난수 발생 */
        int randomInt = random.nextInt(10);
        System.out.println(randomInt);

        /* 1. 1 ~ 10 범위의 난수 발생 */
        int randomInt2 = random.nextInt(10) + 1;
        System.out.println(randomInt2);
    }
}
