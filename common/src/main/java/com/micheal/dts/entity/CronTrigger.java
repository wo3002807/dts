package com.micheal.dts.entity;

/**
 * Created by michael on 2018/11/5.
 */
public class CronTrigger {
    private Key key;
    private String cronExpression;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}
