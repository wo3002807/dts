package com.micheal.dts.controller;


import com.micheal.dts.io.RespCode;
import com.micheal.dts.io.RespData;
import com.micheal.dts.service.PackageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(tags = "任务包管理")
@RestController
@RequestMapping(value = "/package")
public class PackageController {

    @Autowired
    PackageService packageService;

    @ApiOperation("任务包上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public RespCode upload(@RequestParam(value = "schedName") String schedName, MultipartFile file) {
        packageService.upload(schedName, file);
        return new RespCode();
    }

    @ApiOperation("任务包删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public RespCode delete() {
        return null;
    }

    @ApiOperation("任务包修改")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public RespCode modify() {
        return null;
    }

    @ApiOperation("查看任务包同步信息")
    @RequestMapping(value = "/sync/view", method = RequestMethod.GET)
    public RespCode view() {
        return null;
    }

    @ApiOperation("任务包同步")
    @RequestMapping(value = "/sync", method = RequestMethod.POST)
    public RespCode sync() {
        return null;
    }

    @ApiOperation("任务包任务名列表查询")
    @RequestMapping(value = "/class-list/query", method = RequestMethod.GET)
    public RespData<List<String>> classNameQuery(@RequestParam(value = "schedName", required = false) String schedName) {
        List<String> data = packageService.classNameQuery(schedName);
        RespData<List<String>> resp = new RespData<>();
        resp.setData(data);
        return resp;
    }
}
