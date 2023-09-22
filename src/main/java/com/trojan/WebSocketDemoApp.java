package com.trojan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.trojan.repository.mapper")
public class WebSocketDemoApp {
    
    public static void main(String[] args) {
        SpringApplication.run(WebSocketDemoApp.class,args);
    }
}