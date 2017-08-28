package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.SourceCode;

public interface SourceCodeMapper {
    int deleteByPrimaryKey(Integer solutionId);

    int insert(Integer solutionId,String source);

    int insertSelective(SourceCode record);

    SourceCode selectByPrimaryKey(Integer solutionId);

    int updateByPrimaryKeySelective(SourceCode record);

    int updateByPrimaryKeyWithBLOBs(SourceCode record);
}