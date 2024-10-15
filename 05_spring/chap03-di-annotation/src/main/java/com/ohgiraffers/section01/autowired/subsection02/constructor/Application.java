package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.autowired.common.BookDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ap = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = ap.getBean("bookServiceConstructor",BookService.class);
        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.selectAllBooks());

        /* IoC 컨테이너 없이 코드를 테스트할 때 생성자를 통해 BookDAO 객체를 전달하므로
        * 아래 코드는 문제 없이 테스트할 수 있다.
        * -> 너무 IoC 컨테이너에 의존하지 말자.. */
        BookService bookService2 = new BookService(new BookDAOImpl());
        bookService2.selectAllBooks();
    }
}