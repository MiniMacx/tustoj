package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.SourceCodeUser;

public interface SourceCodeUserMapper {
    int deleteByPrimaryKey(Integer solutionId);

    int insert(Integer solutionId,String source);

    int insertSelective(SourceCodeUser record);

    SourceCodeUser selectByPrimaryKey(Integer solutionId);

    int updateByPrimaryKeySelective(SourceCodeUser record);

    int updateByPrimaryKeyWithBLOBs(SourceCodeUser record);
}