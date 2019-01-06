package com.micheal.dts.service;

import com.micheal.dts.component.DefaultNodeGenerator;
import com.micheal.dts.component.NodeGenerator;
import com.micheal.dts.component.dao.ExecNodeDao;
import com.micheal.dts.component.dao.SchedulerDao;
import com.micheal.dts.config.SystemConfiguration;
import com.micheal.dts.entity.Node;
import com.micheal.dts.entity.Scheduler;
import com.micheal.dts.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecNodeService {
    private static Logger log = LoggerFactory.getLogger(ExecNodeService.class);
    @Autowired
    ExecNodeDao execNodeDao;

    NodeGenerator nodeGenerator = new DefaultNodeGenerator();

    @Autowired
    SystemConfiguration systemConfiguration;

    @Autowired
    SchedulerDao schedulerDao;

    /**
     * 注册
     */
    public void register() {
        Node node = execNodeDao.check(systemConfiguration.getIp(), systemConfiguration.getPort(), systemConfiguration.getSchedulerName());
        if (node == null) {
            //插入
            node = new Node();
            node.setNodeId(nodeGenerator.generate());
            node.setHost(systemConfiguration.getHost());
            node.setIp(systemConfiguration.getIp());
            node.setPort(systemConfiguration.getPort());
            node.setSchedName(systemConfiguration.getSchedulerName());
            node.setCheckTime(System.currentTimeMillis());
            int result = execNodeDao.register(node);
            Assert.isEqual(1, result, "300001");
        } else {
            //更新
            node.setCheckTime(System.currentTimeMillis());
            int result = execNodeDao.update(node);
            Assert.isEqual(1, result, "300001");
        }
    }

    public void check() {
        while (true) {
            Scheduler scheduler = schedulerDao.selectByName(systemConfiguration.getSchedulerName());
            try {
                //休眠时间
                Thread.sleep(scheduler.getCheckInterval());
            } catch (InterruptedException e) {
                log.error("休眠异常", e);
                continue;
            }
            Node node = new Node();
            node.setIp(systemConfiguration.getIp());
            node.setPort(systemConfiguration.getPort());
            node.setSchedName(systemConfiguration.getSchedulerName());
            node.setCheckTime(System.currentTimeMillis());
            int result = execNodeDao.update(node);
            Assert.isEqual(1, result, "300002");
        }
    }

}
