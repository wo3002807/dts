package com.micheal.dts.intf.oper;

import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.Task;

import java.util.List;

/**
 * 任务操作接口
 */
public interface TaskOper {
    public int addTask();

    public int editTask();

    public int delTask(Key taskKey);

    public List<Task> queryTasks();

    public int execTask(Key taskKey);
}
