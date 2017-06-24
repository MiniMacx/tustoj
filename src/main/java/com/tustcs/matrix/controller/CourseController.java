package com.tustcs.matrix.controller;

import com.tustcs.matrix.entity.Course;
import com.tustcs.matrix.service.CourseService;
import com.tustcs.matrix.utils.Page;
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

    @RequestMapping("/queryCourse")
    @ResponseBody
    public Res<List<Course>> showCourse(Integer pageNow) {
        Res<List<Course>> res = new Res<List<Course>>();
        try {
            List<Course> contestList = courseService.showCourse(pageNow);
            res.setData(contestList);
            res.setMsg(String.valueOf(contestList.size() / Page.pageSize));
            res.setStatus(1);
            return res;
        } catch (Exception e) {
            res.setStatus(0);
            res.setMsg("failed");
            return res;
        }


    }

    @RequestMapping("/queryByTeacerName")
    @ResponseBody
    public Res<List<Course>> showCourseByTeacherName(Integer pageNow, String teacherName) {

        Res<List<Course>> res = new Res<List<Course>>();
        try {
            List<Course> courseList = courseService.showCourseByTeacherName(teacherName, pageNow);
            res.setData(courseList);
            res.setMsg(String.valueOf(courseList.size() / Page.pageSize));
            res.setStatus(1);
            return res;
        } catch (Exception e) {
            res.setMsg("failed");
            res.setStatus(0);
            return res;
        }


    }


    @RequestMapping("/queryByCourseName")
    @ResponseBody
    public Res<List<Course>> showCourseByCourseName(String courseName, Integer pageNow) {

        Res<List<Course>> res = new Res<List<Course>>();
        try {
            List<Course> courseList = courseService.showCourseByCourseName(courseName, pageNow);
            res.setData(courseList);
            res.setMsg(String.valueOf(courseList.size() / Page.pageSize));
            res.setStatus(1);
            return res;
        } catch (Exception e) {
            res.setMsg("failed");
            res.setStatus(0);
            return res;
        }

    }
}
