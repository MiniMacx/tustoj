package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.UserCourse;

import java.util.List;

public interface UserCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCourse record);

    int insertSelective(UserCourse record);

    UserCourse selectByPrimaryKey(Integer id);

    List<UserCourse> listUserCourse(UserCourse record);

    int updateByPrimaryKeySelective(UserCourse record);

    int updateByPrimaryKey(UserCourse record);
}