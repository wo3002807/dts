package com.micheal.dts.component.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by michael on 2019/1/1.
 */
public interface PackageDao {
    List<String> classNameQuery(@Param("schedName") String schedName);
}
