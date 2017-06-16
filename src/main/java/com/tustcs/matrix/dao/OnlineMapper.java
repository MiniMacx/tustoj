package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Online;

public interface OnlineMapper {
    int deleteByPrimaryKey(String hash);

    int insert(Online record);

    int insertSelective(Online record);

    Online selectByPrimaryKey(String hash);

    int updateByPrimaryKeySelective(Online record);

    int updateByPrimaryKey(Online record);
}