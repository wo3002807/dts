package com.micheal.dts.config;


import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.InetAddress;
import java.net.UnknownHostException;

@ConfigurationProperties(prefix = "dts.config")
public class SystemConfiguration {
    private String host;
    private String ip;

    private String schedulerName;

    private String port;

    public SystemConfiguration(ServerProperties serverProperties) {
        try {
            port = String.valueOf(serverProperties.getPort());
            //获取服务器信息
            InetAddress inetAddress = InetAddress.getLocalHost();
            host = inetAddress.getHostName();
            ip = inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            host = "Unknow";
            ip = "*.*.*.*";
        }
    }

    public String getSchedulerName() {
        return schedulerName;
    }

    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public String getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getIp() {
        return ip;
    }
}
