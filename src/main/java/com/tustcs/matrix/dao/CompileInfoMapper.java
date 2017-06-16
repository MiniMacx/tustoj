package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.CompileInfo;

public interface CompileInfoMapper {
    int deleteByPrimaryKey(Integer solutionId);

    int insert(CompileInfo record);

    int insertSelective(CompileInfo record);

    CompileInfo selectByPrimaryKey(Integer solutionId);

    int updateByPrimaryKeySelective(CompileInfo record);

    int updateByPrimaryKeyWithBLOBs(CompileInfo record);
}