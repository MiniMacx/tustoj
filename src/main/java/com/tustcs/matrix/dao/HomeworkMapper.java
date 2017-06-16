package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Homework;
import com.tustcs.matrix.entity.UserHomework;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeworkMapper {
    int deleteByPrimaryKey(Long homeworkId);

    int insert(Homework record);

    int insertSelective(Homework record);

    Homework selectByPrimaryKey(Long homeworkId);

    int updateByPrimaryKeySelective(Homework record);

    int updateByPrimaryKeyWithBLOBs(Homework record);

    int updateByPrimaryKey(Homework record);

<<<<<<< HEAD
    List<Homework> selectHomeworkList(@Param("offset") int offset, @Param("limit") int limitl);
=======
    List<Homework> selectHomeworkList(@Param("offset") int offset,@Param("limit") int limitl);
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d

    List<Homework> selectCreatorId(@Param("creatorId") String creatorId);



    List<Homework> listHomework(List<UserHomework> userHomework);
}