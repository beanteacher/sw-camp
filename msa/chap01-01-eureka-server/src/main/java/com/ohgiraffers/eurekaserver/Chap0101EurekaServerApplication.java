package com.ohgiraffers.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
/* Spring Cloud Netflix Eureka에서 사용되는 어노테이션으로,
* 해당 어플리케이션을 Eureka 서버로 활성화하는 역할을 한다. */
@EnableEurekaServer
public class Chap0101EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap0101EurekaServerApplication.class, args);
    }

}
