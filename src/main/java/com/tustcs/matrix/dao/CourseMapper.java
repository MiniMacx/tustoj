package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

<<<<<<< HEAD

    List<Course> selectCourseList(@Param("startPos") int startPos, @Param("pageSize") int pageSize);

    Integer selectCourseCount();

    List<Course> selectCourseByTeacherName(@Param("teacherName") String teacherName,
                                           @Param("startPos") int startPos, @Param("pageSize") int pageSize);

    Integer selectCourseCountUsingTeacherName(@Param("teacherName") String teacherName);

    List<Course> selectCourseByCourseName(@Param("courseName") String courseName,
                                          @Param("startPos") int startPos, @Param("pageSize") int pageSize);

    Integer selectCourseCountUsingCourseName(@Param("courseName")String courseName);
=======
    List<Course> selectCourseList(@Param("offset") int offset,@Param("limit") int limit);

    List<Course> selectCourseByTeacherName(@Param("teacherName") String teacherName);

    List<Course> selectCourseByCourseName(@Param("courseName")String courseName);
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d

    List<Course> listCourse(int[] arrayCourseId);
}