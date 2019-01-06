package com.micheal.dts.component.dao;

import com.micheal.dts.entity.Node;
import com.micheal.dts.entity.io.ViewNodeRes;

import java.util.List;

/**
 * Created by michael on 2019/1/3.
 */
public interface NodeDao {
    List<ViewNodeRes> view(Node node);
}
