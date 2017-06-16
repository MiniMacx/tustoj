package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.entity.Solution;
import com.tustcs.matrix.dao.SolutionMapper;
import com.tustcs.matrix.service.SolutionService;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-6.
 */
@Service
@Transactional
public class SolutionServiceImpl implements SolutionService {

    @Resource
    SolutionMapper solutionMapper;


    public List<Solution> showSolutionByUserId(Integer pageNow, String loginUserId) {

        List<Solution> solutionList;

        if(pageNow!=null){
            solutionList=solutionMapper.selectSolutionByPage((pageNow - 1) * Page.pageSize,Page.pageSize,
                                                            loginUserId);
        }else {
            return null;
        }

        return solutionList;
    }
}
