package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.CompileInfo;

public interface CompileInfoMapper {
    int deleteByPrimaryKey(Integer solutionId);

    int insert(CompileInfo record);

    int insertSelective(CompileInfo record);

    CompileInfo selectByPrimaryKey(Integer solutionId);

    int updateByPrimaryKeySelective(CompileInfo record);

    int updateByPrimaryKeyWithBLOBs(CompileInfo record);
}