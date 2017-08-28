package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.controller.CourseController;
import com.tustcs.matrix.dao.UserCourseMapper;
import com.tustcs.matrix.entity.Course;
import com.tustcs.matrix.entity.UserCourse;
import com.tustcs.matrix.service.CourseService;
import com.tustcs.matrix.dao.CourseMapper;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-10.
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Resource
    CourseMapper courseMapper;

    @Resource
    UserCourseMapper userCourseMapper;

    @Override
    public List<Course> showCourse(Integer pageNow) {
        List<Course> courseList;

        if(pageNow!=null){
            courseList=courseMapper.selectCourseList((pageNow - 1) * Page.pageSize,Page.pageSize);
        }else {
            return null;
        }

        return courseList;
    }

    @Override
    public List<Course> showCourseByTeacherName(String teacherName, Integer pageNow) {
        List<Course> courseList;

        if(pageNow!=null){
            courseList=courseMapper.selectCourseByTeacherName(teacherName,(pageNow - 1) * Page.pageSize,
                                                             Page.pageSize);
        }else {
            return null;
        }

        return courseList;
    }

    @Override
    public List<Course> showCourseByCourseName(String courseName, Integer pageNow) {
        List<Course> courseList;

        if(pageNow!=null){
            courseList=courseMapper.selectCourseByCourseName(courseName,(pageNow - 1) * Page.pageSize,
                                                            Page.pageSize);
        }else {
            return null;
        }

        return courseList;
    }

    @Override
    public boolean addCourse(Course course) {
        return courseMapper.insertSelective(course)>0;

    }

    @Override
    public boolean deleteCourse(Integer courseId) {
        try {
            userCourseMapper.deleteByCourseId(courseId);
            Course course=new Course();
            course.setCourseId(courseId);
            course.setDeleteFlag(1);
            return courseMapper.updateByPrimaryKeySelective(course)>0;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateCourse(Course course) {
        if(course.getCourseId()>0)
            return courseMapper.updateByPrimaryKeySelective(course)>0;
        return false;
    }


    @Override
    public Course getCourse(Integer courseId) {
        try {
            Course course=courseMapper.selectByPrimaryKey(courseId);
            return course.getDeleteFlag()==0?course:null;
        }catch (Exception e){
            return null;
        }

    }

    public List<String> getCourseStudent(Integer courseId){
        try {
            return userCourseMapper.selectCourseUser(courseId);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public int enroll(String userId, Integer courseId) {
        Course course=courseMapper.selectByPrimaryKey(courseId);
        if(course.getDeleteFlag()==1){
            return -1;
        }

        else if(course.getJoinNum()>=course.getJoinLimit()){
            return -2;
        }
        else if(userCourseMapper.selectIsEnrolled(userId,courseId)!=0){
            return -3;
        }
        else {
            UserCourse userCourse=new UserCourse();
            userCourse.setCourseId(courseId);
            userCourse.setUserId(userId);
            if(courseMapper.addJoinNum(courseId)>0
                    &&userCourseMapper.insertSelective(userCourse)>0){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public List<Course> getUserCourse(String userId) {
        return userCourseMapper.selectUserCourseList(userId);
    }

    @Override
    public List<Course> getTeacherCourse(String userId) {
        return courseMapper.selectTeacherCourse(userId);
    }

    @Override
    public boolean removeUser(String userId, Integer courseId) {
        return userCourseMapper.delete(userId,courseId)>0;
    }
}
