package com.ohgiraffers.chap01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Chap01SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap01SpringSecurityApplication.class, args);
    }

}
