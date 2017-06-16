package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.Homework;

public interface HomeworkMapper {
    int deleteByPrimaryKey(Long homeworkId);

    int insert(Homework record);

    int insertSelective(Homework record);

    Homework selectByPrimaryKey(Long homeworkId);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKeyWithBLOBs(Homework record);

    int updateByPrimaryKey(Homework record);
}