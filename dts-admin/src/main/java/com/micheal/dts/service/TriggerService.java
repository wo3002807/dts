package com.micheal.dts.service;


import com.micheal.dts.component.dao.TriggerDao;
import com.micheal.dts.constant.CommonConstant;
import com.micheal.dts.constant.StateConstant;
import com.micheal.dts.entity.*;
import com.micheal.dts.entity.io.AddTriggerReq;
import com.micheal.dts.entity.io.EditTriggerReq;
import com.micheal.dts.util.Assert;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TriggerService {
    @Autowired
    TaskService taskService;

    @Autowired
    TriggerDao triggerDao;

    /**
     * 添加调度
     */
    public void addTrigger(AddTriggerReq req) {
        Key key = new Key();
        key.setSchedName(req.getSchedName());
        key.setName(req.getName());
        Trigger trigger = triggerDao.queryTrigger(key);
        Assert.isNull(trigger, "200002");

        trigger = new Trigger();
        trigger.setKey(key);
        trigger.setDescription(req.getDescription());
        trigger.setTaskName(req.getTaskName());
        trigger.setState(StateConstant.INITIAL);
        trigger.setPriority(req.getPriority());
        trigger.setType(req.getType());
        trigger.setCalendarName(req.getCalendarName());
        trigger.setUpdateTime(System.currentTimeMillis());
        trigger.setUpdateOper("admin");
        int result = triggerDao.add(trigger);
        Assert.isTrue(result == 1, "600003");

        if (StringUtils.equals(req.getType(), CommonConstant.TYPE_CRON)) {//crontab调度
            CronTrigger cronTrigger = new CronTrigger();
            cronTrigger.setKey(key);
            cronTrigger.setCronExpression(req.getCronExpress());
            result = triggerDao.addCron(cronTrigger);
            Assert.isTrue(result == 1, "600003");
        } else if (StringUtils.equals(req.getType(), CommonConstant.TYPE_SIMPLE)) {
            SimpleTrigger simpleTrigger = new SimpleTrigger();
            simpleTrigger.setKey(key);
            simpleTrigger.setRepeatCount(req.getRepeatCount());
            simpleTrigger.setRepeatInterval(req.getRepeatInterval());
            result = triggerDao.addSimple(simpleTrigger);
            Assert.isTrue(result == 1, "600003");
        }
    }

    public void execTrigger(Key req) {
        //校验trigger不能为空你
        Trigger trigger = triggerDao.queryTrigger(req);
        Assert.notNull(trigger, "100002");
        //校验task不能为空
        Key taskKey = new Key();
        taskKey.setName(trigger.getTaskName());
        taskKey.setSchedName(trigger.getKey().getSchedName());
        Task task = taskService.queryTask(taskKey);
        Assert.notNull(task, "100001");

        //更新调度表中的状态即可
        int result = triggerDao.updateState(req, StateConstant.WAITING, StateConstant.INITIAL);
        Assert.isTrue(result == 1, "600006");

    }


    public void editTrigger(EditTriggerReq req) {
        //只有初始化状态的调度器才能编辑
        Key key = new Key();
        key.setSchedName(req.getSchedName());
        key.setName(req.getName());
        Trigger trigger = triggerDao.queryTrigger(key);
        Assert.isTrue(StringUtils.equals(trigger.getState(), StateConstant.INITIAL), "600004");

        trigger.setDescription(req.getDescription());
        trigger.setTaskName(req.getTaskName());
        trigger.setPriority(req.getPriority());
        trigger.setCalendarName(req.getCalendarName());
        trigger.setUpdateTime(System.currentTimeMillis());
        trigger.setUpdateOper("admin");
        int result = triggerDao.edit(trigger);
        Assert.isTrue(result == 1, "600005");

        if (StringUtils.equals(trigger.getType(), CommonConstant.TYPE_CRON)) {//crontab调度
            if (StringUtils.isNotBlank(req.getCronExpress())) {
                CronTrigger cronTrigger = new CronTrigger();
                cronTrigger.setKey(key);
                cronTrigger.setCronExpression(req.getCronExpress());
                result = triggerDao.editCron(cronTrigger);
                Assert.isTrue(result == 1, "600005");
            }
        } else if (StringUtils.equals(trigger.getType(), CommonConstant.TYPE_SIMPLE)) {
            if (req.getRepeatCount() != null || req.getRepeatInterval() != null) {
                SimpleTrigger simpleTrigger = new SimpleTrigger();
                simpleTrigger.setKey(key);
                simpleTrigger.setRepeatCount(req.getRepeatCount());
                simpleTrigger.setRepeatInterval(req.getRepeatInterval());
                result = triggerDao.editSimple(simpleTrigger);
                Assert.isTrue(result == 1, "600005");
            }
        }
    }

    public void delTrigger(Key req) {
        //trigger不存在，则不能删除
        Trigger trigger = triggerDao.queryTrigger(req);
        Assert.notNull(trigger,"100002");

        int result = triggerDao.del(req);
        Assert.isTrue(result == 1, "600007");
    }

    public void pauseTrigger(Key req) {
        //校验trigger不能为空你
        Trigger trigger = triggerDao.queryTrigger(req);
        Assert.notNull(trigger, "100002");
        //校验task不能为空
        Key taskKey = new Key();
        taskKey.setName(trigger.getTaskName());
        taskKey.setSchedName(trigger.getKey().getSchedName());
        Task task = taskService.queryTask(taskKey);
        Assert.notNull(task, "100001");

        //更新调度表中的状态即可
        int result = triggerDao.updateState(req, StateConstant.WAITING, StateConstant.INITIAL);
        Assert.isTrue(result == 1, "600006");
    }

    public void resumeTrigger(Key req) {
        //校验trigger不能为空你
        Trigger trigger = triggerDao.queryTrigger(req);
        Assert.notNull(trigger, "100002");
        //校验task不能为空
        Key taskKey = new Key();
        taskKey.setName(trigger.getTaskName());
        taskKey.setSchedName(trigger.getKey().getSchedName());
        Task task = taskService.queryTask(taskKey);
        Assert.notNull(task, "100001");

        //更新调度表中的状态即可
        int result = triggerDao.updateState(req, StateConstant.WAITING, StateConstant.INITIAL);
        Assert.isTrue(result == 1, "600006");
    }

    public void stopTrigger(Key req) {
        //校验trigger不能为空你
        Trigger trigger = triggerDao.queryTrigger(req);
        Assert.notNull(trigger, "100002");
        //校验task不能为空
        Key taskKey = new Key();
        taskKey.setName(trigger.getTaskName());
        taskKey.setSchedName(trigger.getKey().getSchedName());
        Task task = taskService.queryTask(taskKey);
        Assert.notNull(task, "100001");

        //更新调度表中的状态即可
        int result = triggerDao.updateState(req, StateConstant.WAITING, StateConstant.INITIAL);
        Assert.isTrue(result == 1, "600006");
    }
}
