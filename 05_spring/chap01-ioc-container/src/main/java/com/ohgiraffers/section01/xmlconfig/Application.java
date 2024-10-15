package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        // 경로
        ApplicationContext ap =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");
        // MemberDTO memberDTO = (MemberDTO) ap.getBean("member");  // bean id
        // MemberDTO memberDTO = ap.getBean(MemberDTO.class);  // 클래스 메타 정보
        MemberDTO memberDTO = ap.getBean("member", MemberDTO.class);  // 클래스 메타 정보
        System.out.println(memberDTO);

    }
}
