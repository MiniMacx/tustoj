package com.tustcs.matrix.controller;

import com.tustcs.matrix.dao.ProblemMapper;
import com.tustcs.matrix.entity.ProblemTopic;
import com.tustcs.matrix.service.ProblemService;
import com.tustcs.matrix.entity.ProblemWithBLOBs;
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

    @Resource
    ProblemMapper problemMapper;

    @RequestMapping("/showdetail/{problemId}")
    @ResponseBody
    public Res<ProblemWithBLOBs> showDetail(@PathVariable("problemId")Integer problemId ){
        Res<ProblemWithBLOBs> res=new Res<ProblemWithBLOBs>();
        res.setData(problemMapper.selectByPrimaryKey(problemId));
        return res;
    }

    @RequestMapping("/show/{pageNow}")
    @ResponseBody
    public Res<List<ProblemTopic>> showProblem(@PathVariable("pageNow") Integer pageNow){
        Res<List<ProblemTopic>> res=new Res<List<ProblemTopic>>();
        return res;
    }
    @RequestMapping("/showbytitle/{pageNow}")
    @ResponseBody
    public Res<List<ProblemTopic>> showProblem(HttpServletRequest request,@PathVariable("pageNow") Integer pageNow){
        Res<List<ProblemTopic>> res=new Res<List<ProblemTopic>>();
        String title=request.getParameter("title");

        return res;
    }
}
