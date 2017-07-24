package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.ContestProblem;

import java.util.List;

public interface ContestProblemMapper {
    int insert(ContestProblem record);

    int insertSelective(ContestProblem record);

    List<Integer> selectProblemId(Integer contestId);

}