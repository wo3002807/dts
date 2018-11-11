package com.micheal.dts.component.dao;

import com.micheal.dts.entity.ExecTask;
import com.micheal.dts.entity.Key;

/**
 * Created by michael on 2018/11/11.
 */
public interface ExecTaskDao {
    ExecTask queryTaskByTaskName(Key taskKey);
}
