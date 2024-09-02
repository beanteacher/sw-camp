package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

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

        /* Spring 컨테이너 종료 전에 프로세스가 종료되어 destroMethod 확인되지 않으므로
        * 컨테이너 종료 코드를 작성한다. */
        ((AnnotationConfigApplicationContext) ac).close();
    }
}
