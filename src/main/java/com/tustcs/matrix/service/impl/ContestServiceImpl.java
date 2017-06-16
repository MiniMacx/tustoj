package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.service.ContestService;
import com.tustcs.matrix.dao.ContestMapper;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-9.
 */
@Service
public class ContestServiceImpl implements ContestService {
    @Resource
    ContestMapper contestMapper;

    @Override
    public List<Contest> showContest(Integer pageNow) {

        List<Contest> contestList;

        if(pageNow!=null){
            contestList=contestMapper.selectContestList((pageNow - 1) * Page.pageSize,Page.pageSize);
        }else {
            return null;
        }

        return contestList;
        }

    @Override
    public List<Contest> showContestByTitle(Integer pageNow, String title) {
        List<Contest> contestList;

        if(pageNow!=null){
            contestList=contestMapper.selectByTitle(title,(pageNow - 1) * Page.pageSize,Page.pageSize);
        }else {
            return null;
        }

        return contestList;

        }



}
