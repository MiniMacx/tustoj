package com.tustcs.matrix.controller;

import com.tustcs.matrix.dao.ProblemMapper;
import com.tustcs.matrix.entity.ProblemTopic;
import com.tustcs.matrix.service.ProblemService;
import com.tustcs.matrix.entity.ProblemWithBLOBs;
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
@RequestMapping("/problem")
public class ProblemController {
    @Resource
    ProblemService problemService;

    @RequestMapping("/queryDetail/{problemId}")
    @ResponseBody
    public Res<ProblemWithBLOBs> showDetail(@PathVariable("problemId")Integer problemId ){
        Res<ProblemWithBLOBs> res=new Res<ProblemWithBLOBs>();
        if(problemService.getProblem(problemId)!=null){
            res.setMsg("problem details");
            res.setStatus(1);
            res.setData(problemService.getProblem(problemId));
            return res;
        }else {
            res.setMsg("failed");
            res.setStatus(0);
            return res;
        }

    }

    @RequestMapping("/queryProblem")
    @ResponseBody
    public Res<List<ProblemWithBLOBs>> showProblem(Integer pageNow){
        Res<List<ProblemWithBLOBs>> res= new Res<List<ProblemWithBLOBs>>();
        try {
            List<ProblemWithBLOBs> problemList = problemService.showProblem(pageNow);
            res.setData(problemList);
            res.setMsg(String.valueOf(problemList.size() / Page.pageSize));
            res.setStatus(1);
            return res;
        } catch (Exception e) {
            res.setMsg("failed");
            res.setStatus(0);
            return res;
        }
    }
    @RequestMapping("/queryProblemByTitle")
    @ResponseBody
    public Res<List<ProblemWithBLOBs>> showProblemByTitle(String title,Integer pageNow){
        Res<List<ProblemWithBLOBs>> res=new Res<List<ProblemWithBLOBs>>();
        try {
            List<ProblemWithBLOBs> problemList = problemService.showProblemByTitle(pageNow,title);
            res.setData(problemList);
            res.setMsg(String.valueOf(problemList.size() / Page.pageSize));
            res.setStatus(1);
            return res;
        } catch (Exception e) {
            res.setMsg("failed");
            res.setStatus(0);
            return res;
        }
    }
}
