package com.micheal.dts.entity.io;

public class AddTaskReq {
    private String name;
    private String schedName;

    private String desc;
    private String simpleClass;
    private String canonicalClass;
    private boolean concurrentable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSimpleClass() {
        return simpleClass;
    }

    public void setSimpleClass(String simpleClass) {
        this.simpleClass = simpleClass;
    }

    public String getCanonicalClass() {
        return canonicalClass;
    }

    public void setCanonicalClass(String canonicalClass) {
        this.canonicalClass = canonicalClass;
    }

    public boolean isConcurrentable() {
        return concurrentable;
    }

    public void setConcurrentable(boolean concurrentable) {
        this.concurrentable = concurrentable;
    }
}
