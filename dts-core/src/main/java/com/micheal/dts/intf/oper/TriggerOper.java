package com.micheal.dts.intf.oper;

import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.Trigger;

import java.util.List;

/**
 * 调度管理操作接口
 */
public interface TriggerOper {
    public int add();

    public int addTrigger();

    public int editTrigger();

    public int delTrigger();

    public List<Trigger> queryTriggers();

    public int schedule();

    public int pause();

    public int resume();

    public int stop();


}
