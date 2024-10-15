package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Owner {
    @PostConstruct  //initMethod와 같은 설정 어노테이션
    public void openShop() {
        System.out.println("사장님이 가게 문을 열였습니다. 이제 쇼핑을 하실 수 있습니다.");
    }
    @PreDestroy // destroyMethod와 같은 설정 어노테이션
    public void closeShop() {
        System.out.println("사장님이 가게 문을 닫았습니다. 이제 쇼핑을 하실 수 없습니다.");
    }
}
