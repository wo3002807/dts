package com.micheal.dts.component.dao;

import com.micheal.dts.entity.Scheduler;
import org.apache.ibatis.annotations.Param;

/**
 * Created by michael on 2019/1/6.
 */
public interface SchedulerDao {
    Scheduler selectByName(@Param("schedName") String schedulerName);
}
