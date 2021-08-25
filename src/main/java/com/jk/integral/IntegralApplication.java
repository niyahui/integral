package com.jk.integral;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jk.integral.dao")
@MapperScan("com.jk.integral.DaoHHC")
public class IntegralApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegralApplication.class, args);
    }

}
