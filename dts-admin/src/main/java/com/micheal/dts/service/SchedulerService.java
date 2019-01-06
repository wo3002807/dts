package com.micheal.dts.service;

import com.micheal.dts.component.dao.SchedulerDao;
import com.micheal.dts.constant.StateConstant;
import com.micheal.dts.entity.Scheduler;
import com.micheal.dts.entity.io.*;
import com.micheal.dts.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService {
    @Autowired
    SchedulerDao schedulerDao;

    public List<String> nameListQuery() {
        List<String> data = schedulerDao.nameListQuery();
        return data;
    }

    public void add(AddSchedulerReq req) {
        Scheduler scheduler = new Scheduler();
        scheduler.setState(StateConstant.EXECUTING);
        scheduler.setCheckInterval(req.getCheckInterval());
        scheduler.setDescription(req.getDescription());
        scheduler.setName(req.getName());
        int result = schedulerDao.add(scheduler);
        Assert.isEqual(1, result, "300003");
    }

    public void edit(EditSchedulerReq req) {
        Scheduler scheduler = new Scheduler();
        scheduler.setState(StateConstant.EXECUTING);
        scheduler.setCheckInterval(req.getCheckInterval());
        scheduler.setDescription(req.getDescription());
        scheduler.setName(req.getName());
        int result = schedulerDao.edit(scheduler);
        Assert.isEqual(1, result, "300003");
    }

    public List<Scheduler> listQuery(String name, String state) {
        List<Scheduler> data = schedulerDao.listQuery(name, state);
        return data;
    }

    public void del(DelSchedulerReq req) {
        int result = schedulerDao.del(req.getName());
        Assert.isEqual(1,result,"300004");
    }

    public void stop(StopSchedulerReq req) {
        int result = schedulerDao.modifyState(req.getName(),"STOP");
        Assert.isEqual(1,result,"300004");
    }

    public void start(StartSchedulerReq req) {
        int result = schedulerDao.modifyState(req.getName(),"EXECUTING");
        Assert.isEqual(1,result,"300004");
    }
}
