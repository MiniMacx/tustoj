package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.CustomInput;

public interface CustomInputMapper {
    int deleteByPrimaryKey(Integer solutionId);

    int insert(CustomInput record);

    int insertSelective(CustomInput record);

    CustomInput selectByPrimaryKey(Integer solutionId);

    int updateByPrimaryKeySelective(CustomInput record);

    int updateByPrimaryKeyWithBLOBs(CustomInput record);
}