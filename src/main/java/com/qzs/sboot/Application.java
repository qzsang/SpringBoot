package com.qzs.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application  {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}