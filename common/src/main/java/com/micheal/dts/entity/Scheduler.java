package com.micheal.dts.entity;

public class Scheduler {
    private String name;
    private String description;
    private Long checkInterval;
    private String state;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
