package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.SourceCodeUser;

public interface SourceCodeUserMapper {
    int deleteByPrimaryKey(Integer solutionId);

    int insert(SourceCodeUser record);

    int insertSelective(SourceCodeUser record);

    SourceCodeUser selectByPrimaryKey(Integer solutionId);

    int updateByPrimaryKeySelective(SourceCodeUser record);

    int updateByPrimaryKeyWithBLOBs(SourceCodeUser record);
}