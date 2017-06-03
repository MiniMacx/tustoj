package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.UserContest;

public interface UserContestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserContest record);

    int insertSelective(UserContest record);

    UserContest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserContest record);

    int updateByPrimaryKey(UserContest record);
}