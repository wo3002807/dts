package com.micheal.dts.component.dao;


import com.micheal.dts.entity.Scheduler;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SchedulerDao {
    List<String> nameListQuery();

    int add(Scheduler scheduler);

    int edit(Scheduler scheduler);

    List<Scheduler> listQuery(@Param("name") String name, @Param("state") String state);

    int del(@Param("name") String name);

    int modifyState(@Param("name") String name, @Param("state") String state);
}
