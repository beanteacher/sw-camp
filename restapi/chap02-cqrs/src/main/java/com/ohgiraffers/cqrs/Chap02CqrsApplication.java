package com.ohgiraffers.cqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
public class Chap02CqrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap02CqrsApplication.class, args);
    }

}
