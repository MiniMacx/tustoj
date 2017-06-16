package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.UserHomework;

import java.util.List;

public interface UserHomeworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserHomework record);

    int insertSelective(UserHomework record);

    UserHomework selectByPrimaryKey(Integer id);

    List<UserHomework> listUserHomework(String userId);

    int updateByPrimaryKeySelective(UserHomework record);

    int updateByPrimaryKey(UserHomework record);
}