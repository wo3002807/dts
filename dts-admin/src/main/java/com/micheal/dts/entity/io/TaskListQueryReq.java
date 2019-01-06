package com.micheal.dts.entity.io;

import com.micheal.dts.entity.Key;

/**
 * Created by michael on 2019/1/1.
 */
public class TaskListQueryReq {
    private String schedName;
    private String name;
    private String simpleClass;

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

    public String getSimpleClass() {
        return simpleClass;
    }

    public void setSimpleClass(String simpleClass) {
        this.simpleClass = simpleClass;
    }
}
