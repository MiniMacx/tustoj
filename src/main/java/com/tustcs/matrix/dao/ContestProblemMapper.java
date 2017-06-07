package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.ContestProblem;

public interface ContestProblemMapper {
    int insert(ContestProblem record);

    int insertSelective(ContestProblem record);
}