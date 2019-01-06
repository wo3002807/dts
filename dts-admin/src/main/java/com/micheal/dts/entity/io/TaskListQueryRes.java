package com.micheal.dts.entity.io;

import com.micheal.dts.entity.Key;

/**
 * 任务列表查询
 */
public class TaskListQueryRes {
    private String schedName;
    private String name;

    private String description;
    private String simpleClass;
    private String canonicalClass;
    private Boolean concurrentable;
    private Boolean isDirty;

    public String getSchedName() {
        return schedName;
    }

    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

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

    public Boolean getConcurrentable() {
        return concurrentable;
    }

    public void setConcurrentable(Boolean concurrentable) {
        this.concurrentable = concurrentable;
    }

    public Boolean getDirty() {
        return isDirty;
    }

    public void setDirty(Boolean dirty) {
        isDirty = dirty;
    }

}
