package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.Privilege;

public interface PrivilegeMapper {
    int insert(Privilege record);

    int insertSelective(Privilege record);
}