package com.tustcs.matrix.controller;

import com.tustcs.matrix.dao.SolutionMapper;
import com.tustcs.matrix.entity.Solution;
import com.tustcs.matrix.service.SolutionService;
import com.tustcs.matrix.dto.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-6.
 */
@Controller
@RequestMapping("/solution")
public class SolutionController {
    @Autowired
    SolutionService solutionService;

    @Resource
    SolutionMapper solutionMapper;

    @RequestMapping(value = "/query")
    @ResponseBody
    public Res showSolution(String userId, Integer pageNow) {
        Res<List<Solution>> res = new Res<List<Solution>>();
        List<Solution> solutionList=solutionService.showSolutionByUserId(pageNow,userId);
        if(solutionList.size()>0) {
            res.setStatus(1);
            res.setData(solutionList);
            res.setMsg(String.valueOf(solutionMapper.selectSolutionCount()));
        }else {
            res.setStatus(0);
            res.setMsg("数据为空");
        }
        return res;
    }

    @RequestMapping(value = "/queryByProblemId")
    @ResponseBody
    public Res showSolutionByProblemId(String userId,Integer problemId,Integer pageNow){
        Res<List<Solution>> res = new Res<List<Solution>>();
        List<Solution> solutionList=solutionService.showSolutionByProblemId(pageNow,userId,problemId);
        if(solutionList.size()>0) {
            res.setStatus(1);
            res.setData(solutionList);
            res.setMsg(String.valueOf(solutionMapper.selectSolutionCountUsingProblemId(userId,problemId)));
        }else {
            res.setStatus(0);
            res.setMsg("数据为空");
        }
        return res;
    }


    @RequestMapping("/insert")
    @ResponseBody
    public Res insertContest(@RequestBody Solution solution){
        Res res=new Res();
        if(solutionService.addSolution(solution)){
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
    public Res updateContest(@RequestBody Solution solution){
        Res res=new Res();
        if(solutionService.updateSolution(solution)){
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
    public Res deleteContest(Integer solutionId){
        Res res=new Res();
        if(solutionService.deleteSolution(solutionId)){
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
    public Res getDetail(Integer solutionId){
        Res res=new Res();
        Solution solution=solutionService.getSolution(solutionId);
        if(solution==null){
            res.setMsg("empty");
            res.setStatus(0);
        }else {
            res.setData(solution);
            res.setStatus(1);
        }
        return res;
    }
}
