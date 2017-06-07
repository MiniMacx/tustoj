package com.tustcs.matrix.service.impl;

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
import java.util.List;

/**
 * Created by polykickshaw on 17-6-6.
 */
@Service
@Transactional
public class SolutionServiceImpl implements SolutionService {

    @Resource
    SolutionMapper solutionMapper;


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
    }
}
