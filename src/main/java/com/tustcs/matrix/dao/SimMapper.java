package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Sim;

public interface SimMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Sim record);

    int insertSelective(Sim record);

    Sim selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Sim record);

    int updateByPrimaryKey(Sim record);
}