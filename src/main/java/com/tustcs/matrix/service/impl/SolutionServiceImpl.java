package com.tustcs.matrix.service.impl;

<<<<<<< HEAD
import com.tustcs.matrix.entity.Solution;
import com.tustcs.matrix.dao.SolutionMapper;
import com.tustcs.matrix.service.SolutionService;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
=======
import com.tustcs.matrix.dao.SolutionMapper;
import com.tustcs.matrix.entity.Solution;
import com.tustcs.matrix.service.SolutionService;
import com.tustcs.matrix.utils.Page;
import com.tustcs.matrix.utils.Res;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
import java.util.List;

/**
 * Created by polykickshaw on 17-6-6.
 */
@Service
@Transactional
public class SolutionServiceImpl implements SolutionService {

    @Resource
    SolutionMapper solutionMapper;


<<<<<<< HEAD
    public List<Solution> showSolutionByUserId(Integer pageNow, String loginUserId) {

        List<Solution> solutionList;

        if(pageNow!=null){
            solutionList=solutionMapper.selectSolutionByPage((pageNow - 1) * Page.pageSize,Page.pageSize,
                                                            loginUserId);
        }else {
            return null;
        }

        return solutionList;
=======
    public Res<List<Solution>> showSolutionByUserId(Integer pageNow, String loginUserId) {

        Res<List<Solution>> res=new Res<List<Solution>>();

        Page page;

        List<Solution> solutionList;

        int totalCount= solutionMapper.selectSolutionCountUsingUserId(loginUserId);

        if(pageNow!=null){
            page=new Page(totalCount,pageNow);
            solutionList=solutionMapper.selectSolutionByPage(page.getStartPos(),page.getPageSize(),loginUserId);
        }else {
            page=new Page(totalCount,1);
            solutionList=solutionMapper.selectSolutionByPage(page.getStartPos(),page.getPageSize(),loginUserId);
        }
        res.setData(solutionList);
        res.setMsg(String.valueOf(page.getTotalPageCount()));
        return res;
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
    }
}
