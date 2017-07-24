package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.controller.CourseController;
import com.tustcs.matrix.entity.Course;
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
        return courseMapper.insert(course)>0;

    }

    @Override
    public boolean deleteCourse(Integer courseId) {
        Course course=new Course();
        course.setCourseId(courseId);
        course.setDeleteFlag(1);
        return courseMapper.updateByPrimaryKeySelective(course)>0;
    }

    @Override
    public boolean updateCourse(Course course) {
        return courseMapper.updateByPrimaryKeySelective(course)>0;
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


}
