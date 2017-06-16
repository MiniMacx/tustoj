package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.dao.ProblemMapper;
import com.tustcs.matrix.entity.ProblemWithBLOBs;
import com.tustcs.matrix.service.ProblemService;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-9.
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Resource
    ProblemMapper problemMapper;


    @Override
    public List<ProblemWithBLOBs> showProblem(Integer pageNow) {
        List<ProblemWithBLOBs> problemList;

        if(pageNow!=null){
            problemList=problemMapper.selectProblemList((pageNow - 1) * Page.pageSize,Page.pageSize);
        }else {
            return null;
        }

        return problemList;
    }

    @Override
    public List<ProblemWithBLOBs> showProblemByTitle(Integer pageNow, String title) {
        List<ProblemWithBLOBs> problemList;

        if(pageNow!=null){
            problemList=problemMapper.selectByTitle(title,(pageNow - 1) * Page.pageSize,Page.pageSize);
        }else {
            return null;
        }

        return problemList;
    }
}
