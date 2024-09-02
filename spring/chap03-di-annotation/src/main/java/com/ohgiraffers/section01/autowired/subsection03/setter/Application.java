package com.ohgiraffers.section01.autowired.subsection03.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ap = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = ap.getBean("bookServiceSetter", BookService.class);
        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.selectAllBooks());
    }
}
