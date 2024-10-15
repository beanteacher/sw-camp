package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration("configurationSection03") // Bean으로 등록
@ComponentScan(basePackages = "com.ohgiraffers")
public class ConfigurationContext {
}
