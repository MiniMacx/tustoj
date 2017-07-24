package com.tustcs.matrix.controller;

import com.tustcs.matrix.dao.ContestMapper;
import com.tustcs.matrix.dao.UserMapper;
import com.tustcs.matrix.dto.ContestSum;
import com.tustcs.matrix.dto.Exposer;
import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.entity.User;
import com.tustcs.matrix.service.ContestService;
import com.tustcs.matrix.service.UserService;
import com.tustcs.matrix.dto.Res;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @RequestMapping(value = "/query")
    @ResponseBody
    public Res<List<Contest>> showContest(Integer pageNow){
        Res<List<Contest>> res=new Res<List<Contest>>();

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

    }

    @RequestMapping(value = "/queryByTitle")
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

    @RequestMapping("/insert")
    @ResponseBody
    public Res insertContest(@RequestBody Contest contest){
        Res res=new Res();
        if(contestService.addContest(contest)){
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
    public Res updateContest(@RequestBody Contest contest){
        Res res=new Res();
        if(contestService.updateContest(contest)){
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
    public Res deleteContest(Integer contestId){
        Res res=new Res();
        if(contestService.deleteContest(contestId)){
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
    public Res getDetail(Integer contestId){
        try {
            Res res=new Res();
            Contest contest=contestService.getContest(contestId);
            if(contest==null){
                res.setMsg("empty");
                res.setStatus(0);
            }else {
                res.setData(contest);
                res.setStatus(1);
            }
            return res;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return null;
        }

    }

    @RequestMapping("/enroll")
    @ResponseBody
    public Res enrollContest(String userId,Integer contestId) {
        Res res = new Res();
        User user = userMapper.selectByPrimaryKey(userId);
        Contest contest = contestService.getContest(contestId);
        if (user == null) {
            res.setStatus(0);
            res.setMsg("用户不存在");
            return res;
        }
        if (contestId == null || contestService.getContest(contestId).getDeleteFlag() == 1
                || contest == null) {
            res.setStatus(0);
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
    }


    @RequestMapping(value = "{contestId}/exposer")
    @ResponseBody
    public Res<Exposer> exposer(@PathVariable("contestId") Integer contestId){

        Res<Exposer> res=new Res<Exposer>();
        try {

            Exposer exposer=contestService.exportContestUrl(contestId);
            res.setStatus(1);
            res.setData(exposer);

        }catch (Exception e){
            logger.error(e.getMessage(),e);
            res.setStatus(0);
        }
        return res;
    }

    @RequestMapping(value = "{contestId}/{md5}/sumScore")
    @ResponseBody
    public Res sumScore(@PathVariable("contestId")Integer contestId,@PathVariable("md5")String md5,
                        @CookieValue(value = "userId")String userId){
        if(userId==null){
            return new Res("未登录",0,null);
        }
        ContestSum contestSum=contestService.execution(contestId,userId,md5);
        switch (contestSum.getState()){
            case '1':
                return new Res("成功",1,contestSum);
            default:
                return new Res("失败",0,contestSum);
        }
    }
}
