package com.jbf.spring.jbfspringshiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class JbfSpringShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(JbfSpringShiroApplication.class, args);
    }

}
