package com.micheal.dts.component.dao;

import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.Trigger;

import java.util.List;

/**
 * Created by michael on 2018/11/11.
 */
public interface TriggerDao {
    /**
     * 添加调度
     */
    int add(Trigger task);

    /**
     * 根据调度key来检索调度
     */
    Trigger queryTrigger(Key key);

    /**
     * 编辑调度
     */
    int edit(Trigger task);

    /**
     * 删除调度
     */
    int del(Key key);

    /**
     * 根据任务来查找调度
     */
    List<Trigger> queryTriggerByTaskKey(Key taskKey);
}
