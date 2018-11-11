package com.micheal.dts;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.michael.dts.component.dao"})
@SpringBootApplication
public class ExecNodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExecNodeApplication.class, args);
    }
}
