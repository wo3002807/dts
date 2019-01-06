package com.micheal.dts.controller;

import com.micheal.dts.entity.Scheduler;
import com.micheal.dts.entity.io.*;
import com.micheal.dts.io.RespCode;
import com.micheal.dts.io.RespData;
import com.micheal.dts.service.SchedulerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "调度器管理")
@RestController
@RequestMapping("/scheduler")
public class SchedulerController {
    @Autowired
    SchedulerService schedulerService;

    @ApiOperation(value = "调度器名称列表查询")
    @RequestMapping(value = "/name-list/query", method = RequestMethod.GET)
    public RespData<List<String>> nameListQuery() {
        List<String> data = schedulerService.nameListQuery();
        RespData<List<String>> resp = new RespData<>();
        resp.setData(data);
        return resp;
    }

    @ApiOperation(value = "添加调度器")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RespCode add(@RequestBody AddSchedulerReq req) {
        schedulerService.add(req);
        return new RespCode();
    }

    @ApiOperation(value = "编辑调度器")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public RespCode edit(@RequestBody EditSchedulerReq req) {
        schedulerService.edit(req);
        return new RespCode();
    }

    @ApiOperation(value = "调度器查询")
    @RequestMapping(value = "/list/query", method = RequestMethod.GET)
    public RespData<List<Scheduler>> listQuery(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "state", required = false) String state) {
        List<Scheduler> data = schedulerService.listQuery(name,state);
        RespData<List<Scheduler>> resp = new RespData<>();
        resp.setData(data);
        return resp;
    }

    @ApiOperation(value = "删除调度器")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public RespCode del(@RequestBody DelSchedulerReq req) {
        schedulerService.del(req);
        return new RespCode();
    }

    @ApiOperation(value = "暂停调度器")
    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    public RespCode stop(@RequestBody StopSchedulerReq req) {
        schedulerService.stop(req);
        return new RespCode();
    }

    @ApiOperation(value = "启动调度器")
    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public RespCode start(@RequestBody StartSchedulerReq req) {
        schedulerService.start(req);
        return new RespCode();
    }
}
