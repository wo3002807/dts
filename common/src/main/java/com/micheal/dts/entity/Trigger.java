package com.micheal.dts.entity;

/**
 * Created by michael on 2018/11/5.
 */
public class Trigger  {
    private Key key;
    private String description;
    private String taskName;
    private Long nextFireTime;
    private Long preFireTime;
    private Integer priority;
    private String state;
    private String type;
    private Long startTime;
    private Long endTime;
    private Short misfireInstr;

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(Long nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public Long getPreFireTime() {
        return preFireTime;
    }

    public void setPreFireTime(Long preFireTime) {
        this.preFireTime = preFireTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Short getMisfireInstr() {
        return misfireInstr;
    }

    public void setMisfireInstr(Short misfireInstr) {
        this.misfireInstr = misfireInstr;
    }
}
