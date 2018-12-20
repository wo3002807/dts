package com.micheal.dts.controller;

import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.io.AddTriggerReq;
import com.micheal.dts.entity.io.EditTriggerReq;
import com.micheal.dts.io.RespCode;
import com.micheal.dts.service.TriggerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "调度管理")
@RestController
@RequestMapping(value = "/trigger")
public class TriggerController {
    @Autowired
    TriggerService triggerService;

    @ApiOperation(value = "添加调度")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RespCode add(@RequestBody AddTriggerReq req) {
        triggerService.addTrigger(req);
        return new RespCode();
    }

    @ApiOperation(value = "编辑调度")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public RespCode add(@RequestBody EditTriggerReq req) {
        triggerService.editTrigger(req);
        return new RespCode();
    }

    @ApiOperation(value = "删除调度")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public RespCode del(@RequestBody Key req) {
        triggerService.delTrigger(req);
        return new RespCode();
    }

    @ApiOperation(value = "调度执行")
    @RequestMapping(value = "/exec", method = RequestMethod.POST)
    public RespCode exec(@RequestBody Key req) {
        triggerService.execTrigger(req);
        return new RespCode();
    }

    @ApiOperation(value = "调度暂停")
    @RequestMapping(value = "/pause", method = RequestMethod.POST)
    public RespCode pause(@RequestBody Key req) {
        triggerService.pauseTrigger(req);
        return new RespCode();
    }

    @ApiOperation(value = "调度重新执行")
    @RequestMapping(value = "/resume", method = RequestMethod.POST)
    public RespCode resume(@RequestBody Key req) {
        triggerService.resumeTrigger(req);
        return new RespCode();
    }

    @ApiOperation(value = "调度停止")
    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    public RespCode stop(@RequestBody Key req) {
        triggerService.stopTrigger(req);
        return new RespCode();
    }
}
