package com.micheal.dts;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages={"com.michael.emsp.component.dao"})
@SpringBootApplication
public class AdminApplication {
    public static void main(String [] args){
        SpringApplication.run(AdminApplication.class,args);
    }
}
