package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.Online;

public interface OnlineMapper {
    int deleteByPrimaryKey(String hash);

    int insert(Online record);

    int insertSelective(Online record);

    Online selectByPrimaryKey(String hash);

    int updateByPrimaryKeySelective(Online record);

    int updateByPrimaryKey(Online record);
}