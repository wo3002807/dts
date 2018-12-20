package com.micheal.dts.component.dao;

import com.micheal.dts.entity.CronTrigger;
import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.SimpleTrigger;
import com.micheal.dts.entity.Trigger;
import org.apache.ibatis.annotations.Param;

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
     * 添加crontab调度
     */
    int addCron(CronTrigger cronTrigger);

    /**
     * 添加simple调度
     */
    int addSimple(SimpleTrigger simpleTrigger);

    /**
     * 根据调度key来检索调度
     */
    Trigger queryTrigger(Key key);

    /**
     * 编辑调度
     */
    int edit(Trigger trigger);

    /**
     * 编辑调度
     */
    int editCron(CronTrigger cronTrigger);

    /**
     * 编辑调度
     */
    int editSimple(SimpleTrigger simpleTrigger);

    /**
     * 删除调度
     */
    int del(Key key);

    /**
     * 根据任务来查找调度
     */
    List<Trigger> queryTriggerByTaskKey(Key taskKey);

    /**
     *更新其状态
     */
    int updateState(@Param("key") Key key, @Param("newState") String newState, @Param("oldState") String oldState);
}
