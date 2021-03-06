package com.micheal.dts.controller;

import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.Task;
import com.micheal.dts.entity.io.AddTaskReq;
import com.micheal.dts.entity.io.EditTaskReq;
import com.micheal.dts.entity.io.TaskListQueryReq;
import com.micheal.dts.entity.io.TaskListQueryRes;
import com.micheal.dts.io.RespCode;
import com.micheal.dts.io.RespData;
import com.micheal.dts.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "任务管理")
@RequestMapping(value = "/task")
@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @ApiOperation(value = "添加任务")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RespCode add(@RequestBody AddTaskReq req) {
        taskService.addTask(req);
        return new RespCode();
    }

    @ApiOperation(value = "编辑任务")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public RespCode add(@RequestBody EditTaskReq req) {
        taskService.editTask(req);
        return new RespCode();
    }

    @ApiOperation(value = "删除任务")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public RespCode del(@RequestBody Key req) {
        taskService.delTask(req);
        return new RespCode();
    }

    @ApiOperation(value = "执行任务")
    @RequestMapping(value = "/exec", method = RequestMethod.POST)
    public RespCode exec(@RequestBody Key req) {
        taskService.execTask(req);
        return new RespCode();
    }

    @ApiOperation(value = "任务列表查询")
    @RequestMapping(value = "/list/query", method = RequestMethod.POST)
    public RespData<List<TaskListQueryRes>> listQuery(@RequestBody TaskListQueryReq req) {
        List<Task> data = taskService.listQuery(req);
        List<TaskListQueryRes> respData = new ArrayList<>();
        for (Task task : data) {
            TaskListQueryRes taskListQueryRes = new TaskListQueryRes();
            taskListQueryRes.setName(task.getKey().getName());
            taskListQueryRes.setSchedName(task.getKey().getSchedName());
            taskListQueryRes.setDescription(task.getDescription());
            taskListQueryRes.setSimpleClass(task.getSimpleClass());
            taskListQueryRes.setCanonicalClass(task.getCanonicalClass());
            taskListQueryRes.setConcurrentable(task.getConcurrentable());
            taskListQueryRes.setDirty(task.getDirty());
            respData.add(taskListQueryRes);
        }
        RespData<List<TaskListQueryRes>> resp = new RespData<>();
        resp.setData(respData);
        return resp;
    }
}
