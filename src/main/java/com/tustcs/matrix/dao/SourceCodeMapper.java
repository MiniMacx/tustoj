package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.SourceCode;

public interface SourceCodeMapper {
    int deleteByPrimaryKey(Integer solutionId);

    int insert(SourceCode record);

    int insertSelective(SourceCode record);

    SourceCode selectByPrimaryKey(Integer solutionId);

    int updateByPrimaryKeySelective(SourceCode record);

    int updateByPrimaryKeyWithBLOBs(SourceCode record);
}