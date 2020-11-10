package com.graduate.loyee;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.graduate.loyee.mapper.**")
@Slf4j
public class ShiroTestMain {
    public static void main(String[] args) {
        SpringApplication.run(ShiroTestMain.class,args);
    }
}
