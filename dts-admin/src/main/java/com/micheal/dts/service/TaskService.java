package com.micheal.dts.service;

import com.micheal.dts.component.dao.TaskDao;
import com.micheal.dts.component.dao.TriggerDao;
import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.Task;
import com.micheal.dts.entity.Trigger;
import com.micheal.dts.entity.io.AddTaskReq;
import com.micheal.dts.entity.io.EditTaskReq;
import com.micheal.dts.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskDao taskDao;
    @Autowired
    TriggerDao triggerDao;

    /**
     * 添加任务
     */
    public void addTask(AddTaskReq req) {
        // 判断任务是否存在
        Key key = new Key();
        key.setName(req.getName());
        key.setSchedName(req.getSchedName());
        Task exitTask = taskDao.queryTask(key);
        Assert.isNull(exitTask,"200001");

        Task task = new Task();
        task.setName(req.getName());
        task.setSchedName(req.getSchedName());
        task.setDescription(req.getDescription());
        task.setSimpleClass(req.getSimpleClass());
        task.setCanonicalClass(req.getCanonicalClass());
        task.setConcurrentable(req.isConcurrentable());
        taskDao.add(task);
    }

    /**
     * 编辑任务
     */
    public void editTask(EditTaskReq req) {
        // 判断任务是否存在
        Key key = new Key();
        key.setName(req.getName());
        key.setSchedName(req.getSchedName());
        Task exitTask = taskDao.queryTask(key);
        Assert.notNull(exitTask,"200001");

        Task task = new Task();
        task.setName(req.getName());
        task.setSchedName(req.getSchedName());
        task.setDescription(req.getDescription());
        task.setSimpleClass(req.getSimpleClass());
        task.setCanonicalClass(req.getCanonicalClass());
        task.setConcurrentable(req.isConcurrentable());
        taskDao.edit(task);
    }

    /**
     * 删除任务
     */
    public void delTask(Key taskKey) {
        // 查询任务是否跟调度绑定
        List<Trigger> triggerList = triggerDao.queryTriggerByTaskKey(taskKey);
        Assert.isTrue(triggerList != null || triggerList.isEmpty(),"600001");
        taskDao.del(taskKey);
    }

    /**
     * 执行任务
     */
    public void execTask(Key taskKey) {
        // 查询当前正在执行任务中是否有该任务，如果有该任务，则不能执行

    }
}
