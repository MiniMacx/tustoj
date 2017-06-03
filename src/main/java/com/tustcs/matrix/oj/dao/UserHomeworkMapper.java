package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.UserHomework;

public interface UserHomeworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserHomework record);

    int insertSelective(UserHomework record);

    UserHomework selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserHomework record);

    int updateByPrimaryKey(UserHomework record);
}