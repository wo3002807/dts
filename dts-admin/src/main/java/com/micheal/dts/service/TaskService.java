package com.micheal.dts.service;

import com.micheal.dts.component.dao.TaskDao;
import com.micheal.dts.component.dao.TriggerDao;
import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.Task;
import com.micheal.dts.entity.Trigger;
import com.micheal.dts.entity.io.AddTaskReq;
import com.micheal.dts.entity.io.EditTaskReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskDao taskDao;
    @Autowired
    TriggerDao triggerDao;

    public void addTask(AddTaskReq req) {
        // 判断任务是否存在

        Key key = new Key();
        key.setName(req.getName());
        key.setSchedName(req.getSchedName());
        Task exitTask = taskDao.queryTask(key);
        if (exitTask != null) {
            throw new RuntimeException("新添加的任务已存在");
        }

        Task task = new Task();
        task.setKey(key);
        task.setDesc(req.getDesc());
        task.setSimpleClass(req.getSimpleClass());
        task.setCanonicalClass(req.getCanonicalClass());
        task.setConcurrentable(req.isConcurrentable());
        taskDao.add(task);
    }

    public void editTask(EditTaskReq req) {
        // 判断任务是否存在
        Key key = new Key();
        key.setName(req.getName());
        key.setSchedName(req.getSchedName());
        Task exitTask = taskDao.queryTask(key);
        if (exitTask == null) {
            throw new RuntimeException("新添加的任务不存在");
        }

        Task task = new Task();
        task.setKey(key);
        task.setDesc(req.getDesc());
        task.setSimpleClass(req.getSimpleClass());
        task.setCanonicalClass(req.getCanonicalClass());
        task.setConcurrentable(req.isConcurrentable());
        taskDao.edit(task);
    }

    public void delTask(Key taskKey) {
        // 查询任务是否跟调度绑定
        List<Trigger> triggerList = triggerDao.queryTriggerByTaskKey(taskKey);
        if (triggerList != null || triggerList.isEmpty()) {// 如果绑定了，则不给删除
            throw new RuntimeException("已经跟调度去绑定，请先删除调度");
        }
        taskDao.del(taskKey);
    }

    public void execTask(Key taskKey) {
        // 查询当前正在执行任务中是否有该任务，如果有该任务，则不能执行

    }
}
