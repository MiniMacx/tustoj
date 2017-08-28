package com.tustcs.matrix.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.tustcs.matrix.dao.CourseMapper;
import com.tustcs.matrix.dao.UserCourseMapper;
import com.tustcs.matrix.dao.UserMapper;
import com.tustcs.matrix.entity.Course;
import com.tustcs.matrix.entity.UserCourse;
import com.tustcs.matrix.service.CourseService;
import com.tustcs.matrix.utils.Res;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Resource
    UserMapper userMapper;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/query",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
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

    @RequestMapping(value = "/queryByTeacher",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
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


    @RequestMapping(value = "/queryByCourse",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
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


    @RequestMapping(value = "/insert",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res insertCourse(@RequestBody Course course){
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

    @RequestMapping(value = "/update",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res updateCourse(@RequestBody Course course){
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

    @RequestMapping(value = "/delete",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res deleteCourse(Integer courseId){
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

    @RequestMapping(value = "/queryDetail",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public String getDetail(Integer courseId){
       // Res res=new Res();
        JSONObject jsonObject=new JSONObject();
        Course c=courseService.getCourse(courseId);
        List<String> studentList=courseService.getCourseStudent(courseId);
        if(c==null){
//            res.setMsg("empty");
//            res.setStatus(0);
//            return res;
            jsonObject.put("msg","empty")
                        .put("status",0);
            return Res.jsonToString(jsonObject);
        }else {
//            res.setData(course);
//            res.setStatus(1);
            JSONObject course=new JSONObject();
            course.put("courseId",c.getCourseId())
                    .put("courseName",c.getCourseName())
                    .put("courseTeacher",c.getCourseTeacher())
                    .put("courseTime",c.getCourseTime())
                    .put("course",c.getCourseWeek())
                    .put("courseSection",c.getCourseSection())
                    .put("joinNum",c.getJoinNum())
                    .put("joinLimit",c.getJoinLimit());
            jsonObject.put("course",course)
                    .put("studentList",studentList)
                    .put("status",1)
                    .put("msg","courseDetail");
        }
        return Res.jsonToString(jsonObject);
    }

    //学生的课程列表
    @RequestMapping(value = "/queryUser",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res getUser(String userId){
        Res res=new Res();
        List<Course> userCourseList=courseService.getUserCourse(userId);
        res.setMsg("userCourseList");
        res.setStatus(1);
        res.setData(userCourseList);
        return res;
    }

    //参加课程
    @RequestMapping(value = "/enroll",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res enrollCourse(String userId,Integer courseId){
        Res res=new Res();
        int result=courseService.enroll(userId,courseId);
        switch (result) {
            case 1:
                res.setStatus(1);
                res.setMsg("success!");
                break;
            case -1:
                res.setStatus(0).setMsg("课程已删除");
                break;
            case -2:
                res.setStatus(-2).setMsg("人数已满");
                break;
            case -3:
                res.setStatus(-3).setMsg("已参加");
                break;
            default:
                res.setStatus(-1).setMsg("系统异常");
        }
        return res;
    }

    //老师添加的课程列表
    @RequestMapping(value = "/queryTeacherCourse",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res queryTeacherCourse(String userId){
        Res res=new Res();
        List<Course> courseList=courseService.getTeacherCourse(userId);
        res.setStatus(1);
        res.setData(courseList);
        res.setMsg("teacher's courseList");
        return res;
    }

    //踢出课程中的学生
    @RequestMapping(value = "/kickStudent",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res kickStudent(Integer courseId,String userId,String studentId) {
        Res res = new Res();
        try {
            if (userMapper.selectByPrimaryKey(userId).getLevel() >= 20) {

                if (courseService.removeUser(studentId, courseId)) {
                    res.setStatus(1);
                    res.setMsg("success!");
                } else {
                    res.setStatus(0);
                    res.setMsg("error!");
                }

            }
            return res;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return res.setStatus(-1).setMsg("error");
        }

    }
}
