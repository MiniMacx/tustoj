package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.RuntimeInfo;

public interface RuntimeInfoMapper {
    int deleteByPrimaryKey(Integer solutionId);

    int insert(RuntimeInfo record);

    int insertSelective(RuntimeInfo record);

    RuntimeInfo selectByPrimaryKey(Integer solutionId);

    int updateByPrimaryKeySelective(RuntimeInfo record);

    int updateByPrimaryKeyWithBLOBs(RuntimeInfo record);
}