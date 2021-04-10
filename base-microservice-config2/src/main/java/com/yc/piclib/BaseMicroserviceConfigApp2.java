package com.yc.piclib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class BaseMicroserviceConfigApp2 {

    public static void main(String[] args) {
        SpringApplication.run(BaseMicroserviceConfigApp2.class, args);
    }
}