package com.micheal.dts.component.dao;


import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.Task;

import java.util.List;

public interface TaskDao {
    /**
     * 添加任务
     */
    int add(Task task);

    /**
     * 根据任务key来检索任务
     */
    Task queryTask(Key key);

    /**
     * 编辑任务
     */
    int edit(Task task);

    /**
     * 删除任务
     */
    int del(Key key);

    /**
     * 任务列表查询
     */
    List<Task> listQuery(Task task);
}
