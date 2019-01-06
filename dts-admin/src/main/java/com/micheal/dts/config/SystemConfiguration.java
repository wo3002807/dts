package com.micheal.dts.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 系统配置类
 */
@Configuration
public class SystemConfiguration {

    @Value(value = "${jarPath:/tmp}")
    private String jarPath;

    public String getJarPath() {
        return jarPath;
    }

    public void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }
}
