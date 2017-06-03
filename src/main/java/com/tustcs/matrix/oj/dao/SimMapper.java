package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.Sim;

public interface SimMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Sim record);

    int insertSelective(Sim record);

    Sim selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Sim record);

    int updateByPrimaryKey(Sim record);
}