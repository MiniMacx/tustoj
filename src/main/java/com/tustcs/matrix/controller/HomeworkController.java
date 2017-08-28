package com.tustcs.matrix.controller;

import com.tustcs.matrix.annotation.UserAccess;
import com.tustcs.matrix.config.Config;
import com.tustcs.matrix.dao.HomeworkMapper;
import com.tustcs.matrix.dto.HomeworkDTO;
import com.tustcs.matrix.dto.HomeworkProblemDTO;
import com.tustcs.matrix.entity.Homework;
import com.tustcs.matrix.entity.HomeworkProblem;
import com.tustcs.matrix.service.HomeworkService;
import com.tustcs.matrix.utils.Res;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-7-30.
 */
@Controller
@RequestMapping("/homework")
public class HomeworkController {
    @Resource
    HomeworkService homeworkService;

    @Resource
    HomeworkMapper homeworkMapper;

    @RequestMapping(value = "/query",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res<List<Homework>> showHomework(Integer pageNow) {
        Res<List<Homework>> res = new Res<List<Homework>>();
        List<Homework> homeworkList=homeworkService.showHomework(pageNow);
        if(homeworkList.size()>0) {
            res.setStatus(1);
            res.setData(homeworkList);
            res.setMsg(String.valueOf(homeworkMapper.selectHomeworkCount()));
        }else {
            res.setStatus(0);
            res.setMsg("数据为空");
        }
        return res;


    }

    @RequestMapping(value = "/queryByCreatorId",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res<List<Homework>> showHomeworkByCreatorId(Integer pageNow, String creatorId) {
        try {
            creatorId=new String(creatorId.getBytes("ISO-8859-1"), "UTF-8");
            Res<List<Homework>> res = new Res<List<Homework>>();
            List<Homework> homeworkList=homeworkService.showHomeworkByCreatorId(pageNow,creatorId);
            if(homeworkList.size()>0) {
                res.setStatus(1);
                res.setData(homeworkList);
                res.setMsg(String.valueOf(homeworkMapper.selectHomeworkCountUsingCreatorId(creatorId)));
            }else {
                res.setStatus(0);
                res.setMsg("数据为空");
            }
            return res;
        }catch (Exception e){
            return null;
        }

    }


    @UserAccess(level = Config.TEACHER)
    @RequestMapping(value = "/insert",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res insertHomework(@RequestBody HomeworkDTO homeworkDTO){
        Res res=new Res();
        System.out.println(homeworkDTO.toString());
        if(homeworkService.addHomework(homeworkDTO)){
            res.setMsg("success!");
            res.setStatus(1);
        }else {
            res.setMsg("error");
            res.setStatus(0);
        }
        return res;
    }



    @UserAccess(level = Config.TEACHER)
    @RequestMapping(value = "/update",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res updateHomework(@RequestBody HomeworkDTO homeworkDTO){
        Res res=new Res();
        if(homeworkService.updateHomework(homeworkDTO)){
            res.setMsg("success!");
            res.setStatus(1);
        }else {
            res.setMsg("error");
            res.setStatus(0);
        }
        return res;
    }

    @UserAccess(level = Config.TEACHER)
    @RequestMapping(value = "/delete",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res deleteHomework(Integer homeworkId){
        Res res=new Res();
        if(homeworkService.deleteHomework(homeworkId)){
            res.setMsg("success!");
            res.setStatus(1);
        }else {
            res.setMsg("error");
            res.setStatus(0);
        }
        return res;
    }

    @RequestMapping(value = "/queryDetail",method = RequestMethod.POST,
    produces = ("application/json;charset=UTF-8"))
    @ResponseBody
    public String getDetail(Integer homeworkId){
        Res res=new Res();
        JSONObject jsonObject=new JSONObject();
        Homework h=homeworkService.getHomework(homeworkId);
        List<HomeworkProblemDTO> homeworkProblemDTO=homeworkService.getHomeworkProblem(homeworkId);
        if(h !=null&&h.getDeleteFlag()!=1){
//            res.setMsg("empty");
//            res.setStatus(0);
//            return res;
            JSONObject homework=new JSONObject();
            homework.put("homeworkCreatorId",h.getHomeworkCreatorId())
                    .put("homeworkCreateTime",h.getHomeworkCreateTime())
                    .put("homeworkEndTime",h.getHomeworkEndTime());
            jsonObject.put("status",1)
                    .put("homework",homework)
                    .put("homeworkProblems",homeworkProblemDTO)
                    .put("msg","detail");
        }else {
            jsonObject.put("status",0)
                    .put("msg","作业不存在或已删除");
//            res.setData(homework);
//            res.setStatus(1);
        }
        return Res.jsonToString(jsonObject);
    }


}
