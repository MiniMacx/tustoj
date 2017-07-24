package com.tustcs.matrix.controller;

import com.tustcs.matrix.dao.CourseMapper;
import com.tustcs.matrix.entity.Course;
import com.tustcs.matrix.service.CourseService;
import com.tustcs.matrix.dto.Res;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-10.
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    @Resource
    CourseService courseService;

    @Resource
    CourseMapper courseMapper;

    @RequestMapping("/query")
    @ResponseBody
    public Res<List<Course>> showCourse(Integer pageNow) {
        Res<List<Course>> res = new Res<List<Course>>();
        List<Course> courseList=courseService.showCourse(pageNow);
        if(courseList.size()>0) {
            res.setStatus(1);
            res.setData(courseList);
            res.setMsg(String.valueOf(courseMapper.selectCourseCount()));
        }else {
            res.setStatus(0);
            res.setMsg("数据为空");
        }
        return res;


    }

    @RequestMapping("/queryByTeacher")
    @ResponseBody
    public Res<List<Course>> showCourseByTeacherName(Integer pageNow, String teacherName) {
       try {
           teacherName=new String(teacherName.getBytes("ISO-8859-1"), "UTF-8");
           Res<List<Course>> res = new Res<List<Course>>();
           List<Course> courseList=courseService.showCourseByTeacherName(teacherName,pageNow);
           if(courseList.size()>0) {
               res.setStatus(1);
               res.setData(courseList);
               res.setMsg(String.valueOf(courseMapper.selectCourseCountUsingTeacherName(teacherName)));
           }else {
               res.setStatus(0);
               res.setMsg("数据为空");
           }
           return res;
       }catch (Exception e){
           return null;
       }


    }


    @RequestMapping("/queryByCourse")
    @ResponseBody
    public Res<List<Course>> showCourseByCourseName(String courseName, Integer pageNow) {
        try {
            courseName=new String(courseName.getBytes("ISO-8859-1"), "UTF-8");
            Res<List<Course>> res = new Res<List<Course>>();
            List<Course> courseList=courseService.showCourseByCourseName(courseName,pageNow);
            if(courseList.size()>0) {
                res.setStatus(1);
                res.setData(courseList);
                res.setMsg(String.valueOf(courseMapper.selectCourseCountUsingCourseName(courseName)));
            }else {
                res.setStatus(0);
                res.setMsg("数据为空");
            }
            return res;
        }catch (Exception e){
            return null;
        }

    }


    @RequestMapping("/insert")
    @ResponseBody
    public Res insertContest(@RequestBody Course course){
        Res res=new Res();
        if(courseService.addCourse(course)){
            res.setMsg("success!");
            res.setStatus(1);
        }else {
            res.setMsg("error");
            res.setStatus(0);
        }
        return res;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Res updateContest(@RequestBody Course course){
        Res res=new Res();
        if(courseService.updateCourse(course)){
            res.setMsg("success!");
            res.setStatus(1);
        }else {
            res.setMsg("error");
            res.setStatus(0);
        }
        return res;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Res deleteContest(Integer courseId){
        Res res=new Res();
        if(courseService.deleteCourse(courseId)){
            res.setMsg("success!");
            res.setStatus(1);
        }else {
            res.setMsg("error");
            res.setStatus(0);
        }
        return res;
    }

    @RequestMapping("/queryDetail")
    @ResponseBody
    public Res getDetail(Integer courseId){
        Res res=new Res();
        Course course=courseService.getCourse(courseId);
        if(course==null){
            res.setMsg("empty");
            res.setStatus(0);
            return res;
        }else {
            res.setData(course);
            res.setStatus(1);
        }
        return res;
    }
}
