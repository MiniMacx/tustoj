package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}