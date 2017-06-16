package com.tustcs.matrix.controller;

<<<<<<< HEAD
=======
import com.sun.org.apache.regexp.internal.RE;
import com.tustcs.matrix.dao.UserMapper;
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.service.ContestService;
import com.tustcs.matrix.utils.Res;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-9.
 */
@Controller
@RequestMapping("/contest")
public class ContestController {
    @Resource
    ContestService contestService;

<<<<<<< HEAD
    @RequestMapping(value = "/queryContest/",method = RequestMethod.GET)
    @ResponseBody
    public Res showContest(int pageNow){

        Res<List<Contest>> res=new Res<List<Contest>>();

        res.setData(contestService.showContest(pageNow));
        return res;
    }

    @RequestMapping(value = "/showbytitle/{pageNow}",method = RequestMethod.GET)
    @ResponseBody
    public Res showContestByTitle(HttpServletRequest request,@PathVariable("pageNow") Integer pageNow){
        String title=request.getParameter("title");

        Res<List<Contest>> res=new Res<List<Contest>>();

        return res;
=======
    @RequestMapping(value = "/showcontest/{pageNow}",method = RequestMethod.GET)
    @ResponseBody
    public Res showContest(HttpServletRequest request, @PathVariable("pageNow") Integer pageNow){
        Res<List<Contest>> res=new Res<List<Contest>>();

        return contestService.showContest(pageNow);
    }

    @RequestMapping(value = "/showcontestbytitle/{pageNow}",method = RequestMethod.GET)
    @ResponseBody
    public Res showContestByTitle(HttpServletRequest request,@PathVariable("pageNow") Integer pageNow){
        String title=request.getParameter("title");
        Res<List<Contest>> res=new Res<List<Contest>>();
        return contestService.showContestByTitle(pageNow,title);
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
    }


}
