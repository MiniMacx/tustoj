package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.ContestProblem;

public interface ContestProblemMapper {
    int insert(ContestProblem record);

    int insertSelective(ContestProblem record);
}