package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.Loginlog;

public interface LoginlogMapper {
    int insert(Loginlog record);

    int insertSelective(Loginlog record);
}