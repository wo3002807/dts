package com.micheal.dts.entity;

/**
 * Created by michael on 2018/11/5.
 */
public class SimpleTrigger {
    private Key key;
    private Long repeatInterval;
    private Long repeatCount;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

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
