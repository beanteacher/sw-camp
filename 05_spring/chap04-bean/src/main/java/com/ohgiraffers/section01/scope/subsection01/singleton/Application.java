package com.ohgiraffers.section01.scope.subsection01.singleton;

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
        shoppingCart.addItem(water);

        System.out.println("cart에 담긴 상품 : " + shoppingCart.getItem());
        ShoppingCart shoppingCart2 = ac.getBean("cart", ShoppingCart.class);
        shoppingCart.addItem(water);
        System.out.println("cart에 담긴 상품 : " + shoppingCart2.getItem());
        /* Bean의 기본 스코프는 singleton이다.
        * slngleton 스코프를 갖는 bean은 어플리케이션 내에서 유일한 인스턴스를 갖는다. */
    }
}
