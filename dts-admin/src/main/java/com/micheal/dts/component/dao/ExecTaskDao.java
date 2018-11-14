package com.micheal.dts.component.dao;

import com.micheal.dts.entity.ExecTask;
import com.micheal.dts.entity.Key;


public interface ExecTaskDao {
    /**
     * 根据任务key来查找正在执行的任务
     */
    ExecTask queryTaskByTaskName(Key taskKey);
}
