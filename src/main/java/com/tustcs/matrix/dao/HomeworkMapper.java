package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Homework;
import com.tustcs.matrix.entity.UserHomework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeworkMapper {
    int deleteByPrimaryKey(Integer homeworkId);

    int insert(Homework record);

    int insertSelective(Homework record);

    Homework selectByPrimaryKey(Integer homeworkId);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKeyWithBLOBs(Homework record);

    int updateByPrimaryKey(Homework record);

    List<Homework> selectHomeworkList(@Param("startPos") int startPos, @Param("pageSize") int pageSize);

    Integer selectHomeworkCount();

    List<Homework> selectHomeworkByCreatorId(@Param("startPos") int startPos, @Param("pageSize") int pageSize,
                                             @Param("creatorId") String creatorId);

    Integer selectHomeworkCountUsingCreatorId(@Param("creatorId") String creatorId);

    List<Homework> listHomework(List<UserHomework> userHomework);
}