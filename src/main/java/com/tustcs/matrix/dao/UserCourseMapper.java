package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Course;
import com.tustcs.matrix.entity.UserCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCourseMapper {
    int deleteByCourseId(Integer courseId);

    int delete(@Param("userId") String userId,@Param("courseId")Integer courseId);

    int insert(UserCourse record);

    int insertSelective(UserCourse record);

    UserCourse selectByPrimaryKey(Integer id);

    List<Course> selectUserCourseList(String userId);

    List<UserCourse> listUserCourse(UserCourse record);

    List<String> selectCourseUser(Integer courseId);

    /**
     * 查找记录是否重复
     * @param userId
     * @param courseId
     * @return
     */
    int selectIsEnrolled(@Param("userId")String userId,@Param("courseId")Integer courseId);

    int updateByPrimaryKeySelective(UserCourse record);

    int updateByPrimaryKey(UserCourse record);
}