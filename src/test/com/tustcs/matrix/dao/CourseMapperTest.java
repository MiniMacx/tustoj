package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by polykickshaw on 17-6-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class CourseMapperTest {

    @Resource
    private CourseMapper courseMapper;

    @Test
    public void insertSeletive() throws Exception {
        Course course=new Course();
        course.setCourseTeacher("linn");
        course.setCourseName("algorithi im");
        course.setCourseTime("1-18i周");
        course.setCourseWeek("二 四");
        course.setCourseSection("一");
        courseMapper.insertSelective(course);
    }

}