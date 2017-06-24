package com.tustcs.matrix.controller;

import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.service.ContestService;
import com.tustcs.matrix.utils.Page;
import com.tustcs.matrix.utils.Res;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-9.
 */
@Controller
@RequestMapping("/contest")
public class ContestController {
    @Resource
    ContestService contestService;

    @RequestMapping(value = "/queryContest",method = RequestMethod.GET)
    @ResponseBody
    public Res showContest(Integer pageNow){

        Res<List<Contest>> res=new Res<List<Contest>>();
        try {
            List<Contest> contestList=contestService.showContest(pageNow);
            res.setData(contestList);
            res.setMsg(String.valueOf(contestList.size()/ Page.pageSize));
            res.setStatus(1);
            return res;
        } catch (Exception e) {
            res.setStatus(0);
            res.setMsg("failed");
            return res;
        }

    }

    @RequestMapping(value = "/queryByTitle",method = RequestMethod.GET)
    @ResponseBody
    public Res showContestByTitle(String title,Integer pageNow){

        Res<List<Contest>> res=new Res<List<Contest>>();
        try {
            List<Contest> contestList=contestService.showContestByTitle(pageNow,title);
            res.setData(contestList);
            res.setMsg(String.valueOf(contestList.size()/ Page.pageSize));
            res.setStatus(1);
            return res;
        } catch (Exception e) {
            res.setStatus(0);
            res.setMsg("failed");
            return res;
        }

    }


}
