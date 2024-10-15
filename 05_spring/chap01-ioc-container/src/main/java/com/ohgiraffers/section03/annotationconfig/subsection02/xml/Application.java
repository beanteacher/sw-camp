package com.ohgiraffers.section03.annotationconfig.subsection02.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext ap = new GenericXmlApplicationContext("section03/annotationconfig/spring-context.xml");
        String[] beanNames = ap.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
