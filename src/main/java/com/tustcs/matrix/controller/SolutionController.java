package com.tustcs.matrix.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile;
import com.tustcs.matrix.dao.CompileInfoMapper;
import com.tustcs.matrix.dao.RuntimeInfoMapper;
import com.tustcs.matrix.dao.SolutionMapper;
import com.tustcs.matrix.entity.CompileInfo;
import com.tustcs.matrix.entity.RuntimeInfo;
import com.tustcs.matrix.entity.Solution;
import com.tustcs.matrix.service.SolutionService;
import com.tustcs.matrix.service.UserService;
import com.tustcs.matrix.utils.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    CompileInfoMapper compileInfoMapper;

    @Resource
    RuntimeInfoMapper runtimeInfoMapper;

    @RequestMapping(value = "/query",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res showSolution(String userId, Integer pageNow) {
        Res<List<Solution>> res = new Res<List<Solution>>();
        List<Solution> solutionList=solutionService.showSolutionByUserId(pageNow,userId);
        if(solutionList.size()>0) {
            res.setStatus(1);
            res.setData(solutionList);
            res.setMsg(String.valueOf(solutionMapper.selectSolutionCountUsingUserId(userId)));
        }else {
            res.setStatus(0);
            res.setMsg("数据为空");
        }
        return res;
    }

    @RequestMapping(value = "/queryByProblemId",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res showSolutionByProblemId(String userId,Integer problemId,Integer pageNow){
        Res<List<Solution>> res = new Res<List<Solution>>();
        List<Solution> solutionList=solutionService.showSolutionByProblemId(pageNow,userId,problemId);
        if(solutionList!=null||solutionList.size()>0) {
            res.setStatus(1);
            res.setData(solutionList);
            res.setMsg(String.valueOf(solutionMapper.selectSolutionCountUsingProblemId(userId,problemId)));
        }else {
            res.setStatus(0);
            res.setMsg("数据为空");
        }
        return res;
    }


    @RequestMapping(value = "/insert",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    //problem_id,user_id,in_date,language,ip,code_length,result
    public Res insertSolution(@RequestBody Solution solution){
        Res res=new Res();
        solution.setInDate(new Date());
        solution.setResult((short)14);
        if(solutionService.addSolution(solution)){
            res.setMsg("success!");
            res.setStatus(1);
        }else {
            res.setMsg("error");
            res.setStatus(0);
        }
        return res;
    }

//    @RequestMapping("/insertContest")
//    @ResponseBody
//    //problem_id,user_id,in_date,language,ip,code_length,contest_id,result
//    public Res insertSolutionContest(@RequestBody Solution solution){
//        Res res=new Res();
//        if(solutionService.addSolution(solution)){
//            res.setMsg("success!");
//            res.setStatus(1);
//        }else {
//            res.setMsg("error");
//            res.setStatus(0);
//        }
//        return res;
//    }

    @RequestMapping(value = "/update",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res updateSolution(@RequestBody Solution solution){
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

    @RequestMapping(value = "/delete",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res deleteSolution(Integer solutionId){
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

    @RequestMapping(value = "/queryDetail",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
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

    @RequestMapping(value = "/queryCompileInfo",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res getCompileInfo(Integer solutionId,String userId){
        Res res=new Res();
        try {
            if(userId.equals(solutionService.getSolution(solutionId).getUserId())){
                CompileInfo compileInfo=compileInfoMapper.selectByPrimaryKey(solutionId);
                res.setData(compileInfo).setMsg("compileInfo "+solutionId).setStatus(1);

            }else {
                res.setStatus(0).setMsg("不可查看");
            }
            return res;
        }catch (Exception e) {
            e.printStackTrace();
            return res;
        }
    }

    @RequestMapping(value = "/queryRuntimeInfo",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res getRuntimeInfo(Integer solutionId,String userId){
        Res res=new Res();
        try {
            if(userId.equals(solutionService.getSolution(solutionId).getUserId())){
                RuntimeInfo runtimeInfo=runtimeInfoMapper.selectByPrimaryKey(solutionId);
                res.setData(runtimeInfo).setMsg("runtimeInfo "+solutionId).setStatus(1);

            }else {
                res.setStatus(0).setMsg("不可查看");
            }
            return res;
        }catch (Exception e) {
            e.printStackTrace();
            return res;
        }
    }
}
