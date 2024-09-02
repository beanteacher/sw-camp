package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
    public static void main(String[] args) {
        ApplicationContext ap = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        String[] beanNames = ap.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println(beanName);
        }
        MemberDTO memberDTO = ap.getBean(MemberDTO.class);
        System.out.println(memberDTO);
    }
}
