package com.yc.piclib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//@EnableDiscoveryClient        //服务发现
@EnableEurekaClient
public class PiclibRestApiApp {
    public static void main(String[] args) {
        SpringApplication.run(PiclibRestApiApp.class, args);
    }
}