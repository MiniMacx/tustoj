package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.UserHomework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserHomeworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserHomework record);

    int insertSelective(UserHomework record);

    UserHomework selectByPrimaryKey(Integer id);

    List<UserHomework> listUserHomework(String userId);

    int insertUserHomework(List<UserHomework> homeworkList);

    int updateByPrimaryKeySelective(UserHomework record);

    int updateByPrimaryKey(UserHomework record);
}