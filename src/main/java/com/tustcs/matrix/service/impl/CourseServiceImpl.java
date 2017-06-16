package com.tustcs.matrix.service.impl;

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
}
