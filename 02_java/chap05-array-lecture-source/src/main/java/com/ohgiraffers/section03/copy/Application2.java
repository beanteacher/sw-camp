package com.ohgiraffers.section03.copy;

public class Application2 {
    public static void main(String[] args) {
        /* 얕은 복사를 활용하여 매개변수와 리턴 값으로 활용할 수 있다. */

        String[] names = { "홍길동", "유관순", "이순신" };

        System.out.println("names의 hashCode : " + names.hashCode());

        print(names);

        String[] arr = getAnimals();

        System.out.println("리턴 받은 arr의 hashCode : " + arr.hashCode());

        print(arr);

    }

    public static void print(String[] sarr) {

        System.out.println("sarr의 hashCode : " + sarr.hashCode());

        for(int i = 0; i < sarr.length; i++) {
            System.out.print(sarr[i] + " ");
        }
        System.out.println();
    }

    public static String[] getAnimals() {

        String[] animals = {"낙타", "호랑이", "나무늘보"};

        System.out.println("animals의 hashCode : " + animals.hashCode());

        return animals;
    }



}
