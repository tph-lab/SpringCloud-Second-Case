package com.yc.piclib;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.github.tobato.fastdfs.FdfsClientConfig;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

//因为底层调用了自己写的关于数据库的模块，所以需要排除一些类（piclib-domain）
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class, DataSourceAutoConfiguration.class})
//@EnableDiscoveryClient
@EnableZuulProxy
@EnableHystrix
@EnableFeignClients(basePackages = "com.yc.piclib.client")      // 这样feign可以扫描这个路径下的接口@Feignclient的接口，并生成动态代理对象
//@EnableCircuitBreaker   //启用断路器(熔断机制) @EnableHystrix含有该注解
@SpringCloudApplication
//导入fastdfs客户端的类
@Import(FdfsClientConfig.class)     //@Import通过快速导入的方式实现把实例加入spring的IOC容器中
public class PicWebApp {

    public static void main(String[] args) {
        SpringApplication.run(PicWebApp.class, args);
    }


}

