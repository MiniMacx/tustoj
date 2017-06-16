package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.UserContest;

import java.util.List;

public interface UserContestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserContest record);

    int insertSelective(UserContest record);

    UserContest selectByPrimaryKey(Integer id);

    List<UserContest> selectUserContestList(String userId);

    int updateByPrimaryKeySelective(UserContest record);

    int updateByPrimaryKey(UserContest record);
}