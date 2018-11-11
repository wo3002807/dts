package com.micheal.dts.intf.store;

import com.micheal.dts.entity.Key;
import com.micheal.dts.entity.Trigger;


public interface TriggerStore {

    public int addTrigger();

    public int editTrigger();

    public int delTrigger();

    public Trigger getTrigger(Key triggerKey);
}
