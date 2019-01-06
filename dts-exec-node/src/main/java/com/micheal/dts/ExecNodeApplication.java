package com.micheal.dts;

import com.micheal.dts.config.SystemConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@MapperScan(basePackages = {"com.micheal.dts.component.dao"})
@SpringBootApplication
@EnableConfigurationProperties(SystemConfiguration.class)
public class ExecNodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExecNodeApplication.class, args);
    }
}
