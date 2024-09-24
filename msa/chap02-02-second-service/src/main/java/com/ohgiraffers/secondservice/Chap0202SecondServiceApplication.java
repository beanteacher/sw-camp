package com.ohgiraffers.secondservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Chap0202SecondServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap0202SecondServiceApplication.class, args);
    }

}