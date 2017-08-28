package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Course;

import java.util.List;

/**
 * Created by polykickshaw on 17-6-10.
 */
public interface CourseService {
    List<Course> showCourse(Integer pageNow);

    List<Course> showCourseByTeacherName(String teacherName,Integer pageNow);

    List<Course> showCourseByCourseName(String courseName,Integer pageNow);

    List<Course> getUserCourse(String userId);

    List<Course> getTeacherCourse(String userId);

    Course getCourse(Integer courseId);

    boolean addCourse(Course course);

    boolean deleteCourse(Integer courseId);

    boolean updateCourse(Course course);

    int enroll(String userId,Integer courseId);

    boolean removeUser(String userId,Integer courseId);

    List<String> getCourseStudent(Integer courseId);
}
