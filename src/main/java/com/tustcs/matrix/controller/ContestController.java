package com.tustcs.matrix.controller;

import com.tustcs.matrix.annotation.UserAccess;
import com.tustcs.matrix.config.Config;
import com.tustcs.matrix.dao.ContestMapper;
import com.tustcs.matrix.dao.UserMapper;
import com.tustcs.matrix.dto.ContestDTO;
import com.tustcs.matrix.dto.ContestSum;
import com.tustcs.matrix.dto.Exposer;
import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.entity.ContestProblem;
import com.tustcs.matrix.entity.User;
import com.tustcs.matrix.service.ContestService;
import com.tustcs.matrix.service.UserService;
import com.tustcs.matrix.utils.Res;
import org.omg.CORBA.TRANSACTION_MODE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-9.
 */
@Controller
@RequestMapping("/contest")
public class ContestController {
    @Resource
    ContestService contestService;

    @Resource
    UserService userService;

    @Resource
    UserMapper userMapper;

    @Resource
    ContestMapper contestMapper;



    private final Logger logger=LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/query",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res<List<Contest>> showContest(Integer pageNow){
        Res<List<Contest>> res=new Res<List<Contest>>();
        try {
            List<Contest> contestList=contestService.showContest(pageNow);
            if(contestList.size()>0) {
                res.setStatus(1);
                res.setData(contestList);
                res.setMsg(String.valueOf(contestMapper.selectContestCount()));
            }
            else {
                res.setStatus(0);
                res.setMsg("数据为空");
            }
            return res;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return res.setStatus(-1).setMsg("error");

        }


    }

    @RequestMapping(value = "/queryByTitle",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res showContestByTitle(String title,Integer pageNow){
    try {
        title=new String(title.getBytes("ISO-8859-1"),"UTF-8");
        Res<List<Contest>> res=new Res<List<Contest>>();

        List<Contest> contestList=contestService.showContestByTitle(pageNow,title);
        if(contestList!=null) {
            res.setStatus(1);
            res.setData(contestList);
            res.setMsg(String.valueOf(contestMapper.selectContestCountUsingTitle(title)));
        }else {
            res.setStatus(0);
            res.setMsg("数据为空");
        }
        return res;
    }catch (Exception e){
        logger.error(e.getMessage(),e);
        return  null;
    }

    }

    @UserAccess(level = Config.ADMINISTRATOR)
    @RequestMapping(value = "/insert",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res insertContest(@RequestBody ContestDTO contestDTO){
        Res res=new Res();
        try {
            if(contestService.addContest(contestDTO)){
                res.setMsg("success!");
                res.setStatus(1);
            }else {
                res.setMsg("error");
                res.setStatus(0);
            }
            return res;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return res.setStatus(-1).setMsg("error");
        }

    }


    @RequestMapping(value = "/update",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res updateContest(@RequestBody Contest contest){
        Res res=new Res();
        try {
            if(contestService.updateContest(contest)){
                res.setMsg("success!");
                res.setStatus(1);
            }else {
                res.setMsg("error");
                res.setStatus(0);
            }
            return res;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return res.setStatus(-1).setMsg("error");
        }

    }

    @UserAccess(level = Config.ADMINISTRATOR)
    @RequestMapping(value = "/delete",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res deleteContest(Integer contestId){
        Res res=new Res();
        try {
            if(contestService.deleteContest(contestId)){
                res.setMsg("success!");
                res.setStatus(1);
            }else {
                res.setMsg("error");
                res.setStatus(0);
            }
            return res;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return res.setStatus(-1).setMsg("error");
        }

    }

    @RequestMapping(value = "/queryDetail",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res getDetail(Integer contestId){
        Res res=new Res();

        try {
            Contest contest=contestService.getContest(contestId);
            if(contest==null){
                res.setMsg("empty");
                res.setStatus(0);
            }
            else if(contest.getPrivateFlag()==1){
                res.setMsg("需要密码");
                res.setStatus(-1);
            }
            else {
                res.setData(contest);
                res.setStatus(1);
            }
            return res;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return res.setStatus(-1).setMsg("error");
        }

    }

    @RequestMapping(value = "/checkPassword",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res checkPassword(Integer contestId,String password){
        Res res= new Res();
        try {
            if(password.equals(contestService.getContest(contestId).getPassword())){
                res.setStatus(1);
                res.setMsg("密码正确");
                return res;
            }
            res.setMsg("error");
            res.setStatus(0);
            return res;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return res.setStatus(-1).setMsg("error");
        }

    }

    @RequestMapping(value = "/enroll",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res enrollContest(String userId,Integer contestId) {
        Res res = new Res();
        try {
            User user = userMapper.selectByPrimaryKey(userId);
            Contest contest = contestService.getContest(contestId);
            if (user == null) {
                res.setStatus(-1);
                res.setMsg("用户不存在");
                return res;
            }
            if (contestId == null || contest == null || contest.getDeleteFlag()!=0) {
                res.setStatus(-2);
                res.setMsg("比赛不存在或已经删除！");
                return res;
            }
            if (contestService.enrollContest(userId, contestId)) {
                res.setMsg("success");
                res.setStatus(1);
            } else {
                res.setMsg("error");
                res.setStatus(0);
            }
            return res;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return res.setStatus(-1).setMsg("error");
        }

    }


    @RequestMapping(value = "{contestId}/exposer",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res<Exposer> exposer(@PathVariable("contestId") Integer contestId){

        Res<Exposer> res=new Res<Exposer>();
        try {

            Exposer exposer=contestService.exportContestUrl(contestId);
            if(exposer.getExportId()==null){
                res.setStatus(-2).setMsg("比赛不存在");
                return res;
            }else if(exposer.getIsExposed()==false){
                res.setStatus(-3).setMsg("比赛已结束");
                return res;
            }
            res.setStatus(1);
            res.setData(exposer);
            return res;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return res.setStatus(-1).setMsg("error");
        }

    }

    @RequestMapping(value = "{contestId}/{md5}/sumScore",method = RequestMethod.POST,
            produces =("application/json;charset=UTF-8"))
    @ResponseBody
    public Res sumScore(@PathVariable("contestId")Integer contestId,@PathVariable("md5")String md5,
                        String userId){
       try {
           if(userId==null){
               return new Res("未登录",-2,null);
           }
           ContestSum contestSum=contestService.execution(contestId,userId,md5);
           switch (contestSum.getState()){
               case 1:
                   return new Res("成功",1,contestSum);
               default:
                   return new Res("失败",0,contestSum);
           }
       }catch (Exception e){
           logger.error(e.getMessage(),e);
           return new Res("error",-1,null);
       }

    }
}
