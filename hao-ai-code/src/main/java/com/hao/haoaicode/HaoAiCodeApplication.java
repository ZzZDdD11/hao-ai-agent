package com.hao.haoaicode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
@MapperScan("com.hao.haoaicode.mapper")
public class HaoAiCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaoAiCodeApplication.class, args);
    }

}
