package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Loginlog;

public interface LoginlogMapper {
    int insert(Loginlog record);

    int insertSelective(Loginlog record);
}