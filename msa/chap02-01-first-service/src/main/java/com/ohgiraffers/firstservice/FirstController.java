package com.ohgiraffers.firstservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/first-service")
public class FirstController {

    @Autowired
    private Environment environment;

    @GetMapping("/health")
    public String healthCheck() {
        return "I'm Ok. Port = " + environment.getProperty("local.server.port");
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        System.out.println("넘어온 header 값 : " + header);
        return "First Service Message";
    }
}
