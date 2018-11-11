package com.micheal.dts.entity;

/**
 * Created by michael on 2018/11/5.
 */
public class CronTrigger extends Trigger {
    private String cronExpression;

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}
