package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /* 슈퍼에 상품이 진열되어 있다. */
        Product carpBread = ac.getBean("carpBread", Product.class);
        Product milk = ac.getBean("milk", Product.class);
        Product water = ac.getBean("water", Product.class);

        ShoppingCart shoppingCart = ac.getBean("cart", ShoppingCart.class);
        shoppingCart.addItem(carpBread);
        shoppingCart.addItem(milk);

        System.out.println("cart에 담긴 상품 : " + shoppingCart.getItem());
        ShoppingCart shoppingCart2 = ac.getBean("cart", ShoppingCart.class);
        shoppingCart2.addItem(water);
        System.out.println("cart에 담긴 상품 : " + shoppingCart2.getItem());
        /* Bean의 스코프를 prototype으로 변경하면 매번 다른 객체의 cart를 반환한다.
        * 따라서 손님 두 명이 각각 다른 쇼핑 카트를 이용해 상품을 담을 수 있다. */
    }
}
