package com.tustcs.matrix.controller;

import com.tustcs.matrix.annotation.UserAccess;
import com.tustcs.matrix.config.Config;
import com.tustcs.matrix.dao.ProblemMapper;
import com.tustcs.matrix.entity.Problem;
import com.tustcs.matrix.service.ProblemService;
import com.tustcs.matrix.entity.ProblemWithBLOBs;
import com.tustcs.matrix.utils.Res;
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
@RequestMapping("/problem")
public class ProblemController {
    @Resource
    ProblemService problemService;

    @Resource
    ProblemMapper problemMapper;

    @RequestMapping(value = "/queryDetail",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res<ProblemWithBLOBs> showDetail(Integer problemId ){
        Res<ProblemWithBLOBs> res=new Res<ProblemWithBLOBs>();
        ProblemWithBLOBs problem=problemService.getProblem(problemId);
        if(problem!=null){
            res.setMsg("problem detail");
            res.setStatus(1);
            res.setData(problem);

        }else {
            res.setMsg("failed");
            res.setStatus(0);

        }
        return res;
    }

    @RequestMapping(value = "/query",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res<List<ProblemWithBLOBs>> showProblem(Integer pageNow){
        Res<List<ProblemWithBLOBs>> res = new Res<List<ProblemWithBLOBs>>();
        List<ProblemWithBLOBs> problemList=problemService.showProblem(pageNow);
        if(problemList.size()>0) {
            res.setMsg(String.valueOf(problemMapper.selectProblemCount()));
            res.setStatus(1);
            res.setData(problemList);
        }else {
            res.setStatus(0);
            res.setMsg("数据为空");
        }
        return res;
    }

    @RequestMapping(value = "/queryById",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res showProblemById(Integer pageNow,Integer problemId){
        try {
            List<ProblemWithBLOBs> problemList=problemService.showProblemById(pageNow,problemId);
            Res<List<ProblemWithBLOBs>> res=new Res<List<ProblemWithBLOBs>>();
            if(problemList.size()>0){
                res.setStatus(1);
                res.setData(problemList);
                res.setMsg(String.valueOf(problemMapper.selectProblemCountUsingId(problemId)));
            }else {
                res.setStatus(0);
                res.setMsg("数据为空");
            }
            return res;
        }catch (Exception e){
            return null;
        }
    }


    @RequestMapping(value = "/queryByTitle",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res<List<ProblemWithBLOBs>> showProblemByTitle(String title,Integer pageNow){
        try {
            title=new String(title.getBytes("ISO-8859-1"), "UTF-8");
            Res<List<ProblemWithBLOBs>> res = new Res<List<ProblemWithBLOBs>>();
            List<ProblemWithBLOBs> problemList=problemService.showProblemByTitle(pageNow,title);
            if(problemList.size()>0) {
                res.setStatus(1);
                res.setData(problemList);
                res.setMsg(String.valueOf(problemMapper.selectProblemCountUsingTitle(title)));
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
    public Res insertContest(@RequestBody ProblemWithBLOBs problem){
        Res res=new Res();
        if(problemService.addProblem(problem)){
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
    public Res updateContest(@RequestBody ProblemWithBLOBs problem){
        Res res=new Res();
        if(problemService.updateProblem(problem)){
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
    public Res deleteContest(Integer problemId){
        Res res=new Res();
        if(problemService.deleteProblem(problemId)){
            res.setMsg("success!");
            res.setStatus(1);
        }else {
            res.setMsg("error");
            res.setStatus(0);
        }
        return res;
    }

    /*@RequestMapping("/getDetail")
    @ResponseBody
    public Res getDetail(Integer problemId){
        Res res=new Res();
        ProblemWithBLOBs problem=problemService.getProblem(problemId);
        if(problem==null){
            res.setMsg("empty");
            res.setStatus(0);
        }else {
            res.setData(problem);
            res.setStatus(1);
        }
        return res;
    }*/
}
