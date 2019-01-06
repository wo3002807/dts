package com.micheal.dts.service;

import com.micheal.dts.component.dao.NodeDao;
import com.micheal.dts.entity.Node;
import com.micheal.dts.entity.io.ViewNodeRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeService {
    @Autowired
    NodeDao nodeDao;
    public List<ViewNodeRes> view(String schedName,String state) {
        Node node = new Node();
        node.setSchedName(schedName);

        List<ViewNodeRes> data = nodeDao.view(node);
        return data;
    }
}
