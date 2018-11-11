package com.micheal.dts.component.dao;

import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.Trigger;

import java.util.List;

/**
 * Created by michael on 2018/11/11.
 */
public interface TriggerDao {
    int add(Trigger task);

    Trigger queryTrigger(Key key);

    int edit(Trigger task);

    int del(Key key);

    /**
     * 根据任务来查找调度
     */
    List<Trigger> queryTriggerByTaskKey(Key taskKey);
}
