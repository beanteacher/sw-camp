package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ap = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");
        MemberDTO memberDTO = ap.getBean(MemberDTO.class);
        System.out.println(memberDTO);
    }
}
