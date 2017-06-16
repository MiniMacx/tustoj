package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Privilege;

public interface PrivilegeMapper {
    int insert(Privilege record);

    int insertSelective(Privilege record);
}