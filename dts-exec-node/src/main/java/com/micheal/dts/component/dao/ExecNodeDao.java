package com.micheal.dts.component.dao;

import com.micheal.dts.entity.Node;
import org.apache.ibatis.annotations.Param;

/**
 * Created by michael on 2019/1/6.
 */
public interface ExecNodeDao {
    /**
     * 检测执行节点是否存在
     */
    Node check(@Param("ip") String ip, @Param("port") String port, @Param("schedName") String schedName);

    int register(Node node);

    int update(Node node);
}
