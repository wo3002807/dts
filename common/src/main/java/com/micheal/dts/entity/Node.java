package com.micheal.dts.entity;

/**
 * Created by michael on 2019/1/3.
 */
public class Node {
    private String nodeId;
    private String host;
    private String ip;
    private String port;
    private String schedName;
    private Long checkTime;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public Long getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Long checkTime) {
        this.checkTime = checkTime;
    }
}
