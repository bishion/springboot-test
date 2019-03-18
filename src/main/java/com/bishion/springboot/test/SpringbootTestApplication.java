package com.bishion.springboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTestApplication.class,args);
    }

}
