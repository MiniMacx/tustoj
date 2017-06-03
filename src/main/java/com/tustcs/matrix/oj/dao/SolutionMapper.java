package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.Solution;

public interface SolutionMapper {
    int deleteByPrimaryKey(Integer solutionId);

    int insert(Solution record);

    int insertSelective(Solution record);

    Solution selectByPrimaryKey(Integer solutionId);

    int updateByPrimaryKeySelective(Solution record);

    int updateByPrimaryKey(Solution record);
}