package com.micheal.dts.component.dao;


import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.Task;

public interface TaskDao {
    int add(Task task);

    Task queryTask(Key key);

    int edit(Task task);

    int del(Key key);

}
