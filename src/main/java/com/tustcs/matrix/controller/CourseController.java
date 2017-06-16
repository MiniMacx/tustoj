package com.tustcs.matrix.controller;

import com.tustcs.matrix.entity.Course;
import com.tustcs.matrix.service.CourseService;
import com.tustcs.matrix.utils.Res;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-10.
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    @Resource
    CourseService courseService;

    @RequestMapping("/show/{pageNow}")
    @ResponseBody
    public Res<List<Course>> showCourse(@PathVariable("pageNow") Integer pageNow){
        Res<List<Course>> res= new Res<List<Course>>();

        return res;

    }

    @RequestMapping("/showbyteachername/{pageNow}")
    @ResponseBody
    public Res<List<Course>> showCourseByTeacherName(HttpServletRequest request,@PathVariable("pageNow") Integer pageNow){
        String teacherName=request.getParameter("teacherName");
        Res<List<Course>> res= new Res<List<Course>>();

        return res;

    }


    @RequestMapping("/showbycoursename/{pageNow}")
    @ResponseBody
    public Res<List<Course>> showCourseByCourseName(HttpServletRequest request,@PathVariable("pageNow") Integer pageNow){
        String courseName=request.getParameter("courseName");

        Res<List<Course>> res= new Res<List<Course>>();

        return res;

    }
}
