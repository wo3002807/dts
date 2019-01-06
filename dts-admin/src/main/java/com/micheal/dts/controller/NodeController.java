package com.micheal.dts.controller;

import com.micheal.dts.entity.io.ViewNodeRes;
import com.micheal.dts.io.RespData;
import com.micheal.dts.service.NodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "节点管理")
@RestController
@RequestMapping(value = "/node")
public class NodeController {
    @Autowired
    NodeService nodeService;

    @ApiOperation(value = "查看节点状态信息")
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public RespData<List<ViewNodeRes>> view(@RequestParam(value = "schedName", required = false) String schedName, @RequestParam(value = "state", required = false) String state) {
        List<ViewNodeRes> data = nodeService.view(schedName,state);
        RespData<List<ViewNodeRes>> res = new RespData<>();
        res.setData(data);
        return res;
    }
}
