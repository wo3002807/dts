package com.micheal.dts.entity;

/**
 * Created by michael on 2018/11/5.
 */
public class Task extends Key{
    private String description;
    private String simpleClass;
    private String canonicalClass;
    private Boolean concurrentable;
    private Boolean isDirty;
    private String staticData;

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

    public String getStaticData() {
        return staticData;
    }

    public void setStaticData(String staticData) {
        this.staticData = staticData;
    }
}
