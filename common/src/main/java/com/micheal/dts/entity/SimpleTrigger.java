package com.micheal.dts.entity;

/**
 * Created by michael on 2018/11/5.
 */
public class SimpleTrigger {
    private Long repeatInterval;
    private Long repeatCount;

    public Long getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(Long repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public Long getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(Long repeatCount) {
        this.repeatCount = repeatCount;
    }
}
