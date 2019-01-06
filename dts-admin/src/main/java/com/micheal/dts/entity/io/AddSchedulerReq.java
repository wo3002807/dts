package com.micheal.dts.entity.io;

/**
 * Created by michael on 2019/1/6.
 */
public class AddSchedulerReq {
    private String name;
    private String description;
    private Long checkInterval;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCheckInterval() {
        return checkInterval;
    }

    public void setCheckInterval(Long checkInterval) {
        this.checkInterval = checkInterval;
    }

}
