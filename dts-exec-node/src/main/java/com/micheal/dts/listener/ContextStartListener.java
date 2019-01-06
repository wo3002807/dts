package com.micheal.dts.listener;

import com.micheal.dts.service.ExecNodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 容器启动完成后，自动注入
 */
@Configuration
public class ContextStartListener implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger log = LoggerFactory.getLogger(ContextStartListener.class);

    @Autowired
    ExecNodeService execNodeService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //将自身节点注入到集群
        execNodeService.register();
        //添加定时任务，定时检测信息
        execNodeService.check();
    }
}
