package com.micheal.dts.intf.store;

import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.Task;

/**
 * Created by michael on 2018/11/11.
 */
public interface TaskStore {

    public int addTask(Task task);

    public int editTask();

    public int delTask();

    public Task getTask(Key taskKey);

}
