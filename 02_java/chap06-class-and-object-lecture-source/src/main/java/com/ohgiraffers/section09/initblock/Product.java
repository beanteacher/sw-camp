package com.ohgiraffers.section09.initblock;

public class Product {
    /* 1. JVM 지정한 기본값 초기화 */
//    private String name;
//    private int price;
//    private static String brand;

    /* 2. 명시적 초기화 */
    private String name = "갤럭시";
    private int price = 1000000;
    private static String brand = "삼송";

    /* 3. 초기화 블럭 */
    /* 인스턴스 초기화 블럭 */
    {
        name = "사이언";
        price = 800000;

        brand = "사과";
        System.out.println("인스턴스 초기화 블럭 동작");
    }
    /* static 초기화 블럭 */
    static {
        brand = "헬지";

//        name = "아이뽕";
//        price = 1500000;
        System.out.println("static 초기화 블럭 동작");
    }

    public Product() {
        System.out.println("기본 생성자 동작");
    }

    public Product(String name, int price, String brand) {
        this.name = name;
        this.price = price;
        Product.brand = brand;
        System.out.println("매개변수 생성자 동작");
    }

    public String getInformation() {
        return this.name + " " + this.price + " " + Product.brand;
    }
}
