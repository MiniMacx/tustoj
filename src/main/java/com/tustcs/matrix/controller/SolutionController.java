package com.tustcs.matrix.controller;

import com.tustcs.matrix.dao.UserMapper;
import com.tustcs.matrix.entity.User;
import com.tustcs.matrix.entity.Solution;
import com.tustcs.matrix.service.SolutionService;
import com.tustcs.matrix.utils.Page;
import com.tustcs.matrix.utils.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-6.
 */
@Controller
@RequestMapping("/solution")
public class SolutionController {
    @Autowired
    SolutionService solutionService;


    @RequestMapping(value = "queryByUserId", method = RequestMethod.GET)
    @ResponseBody
    public Res showSolution(String userId, Integer pageNow) {
        // 取得SESSION中的loginUser
        Res<List<Solution>> res = new Res<List<Solution>>();
        try {
            List<Solution> problemList = solutionService.showSolutionByUserId(pageNow, userId);
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
