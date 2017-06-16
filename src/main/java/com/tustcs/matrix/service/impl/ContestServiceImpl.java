package com.tustcs.matrix.service.impl;

<<<<<<< HEAD
import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.service.ContestService;
import com.tustcs.matrix.dao.ContestMapper;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
=======
import com.tustcs.matrix.dao.ContestMapper;
import com.tustcs.matrix.dao.SolutionMapper;
import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.entity.Solution;
import com.tustcs.matrix.service.ContestService;
import com.tustcs.matrix.utils.Page;
import com.tustcs.matrix.utils.Res;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
import java.util.List;

/**
 * Created by polykickshaw on 17-6-9.
 */
@Service
public class ContestServiceImpl implements ContestService {
    @Resource
    ContestMapper contestMapper;

    @Override
<<<<<<< HEAD
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


=======
    public Res<List<Contest>> showContest(Integer pageNow) {

        Res<List<Contest>> res= new Res<List<Contest>>();

        Page page;

        List<Contest> contestList;

        int totalCount= contestMapper.selectContestCount();

        if(pageNow!=null){
            page=new Page(totalCount,pageNow);
            contestList=contestMapper.selectContestList(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(totalCount,1);
            contestList=contestMapper.selectContestList(page.getStartPos(),page.getPageSize());
        }
        res.setData(contestList);
        res.setMsg(String.valueOf(page.getTotalPageCount()));
        return res;
        }

    @Override
    public Res<List<Contest>> showContestByTitle(Integer pageNow, String title) {
        Res<List<Contest>> res= new Res<List<Contest>>();

        Page page;

        List<Contest> contestList;

        try {
            //String theTitle=new String(title.getBytes("UTF-8"));
            int totalCount= contestMapper.selectContestCountUsingTitle(title);

            if(pageNow!=null){
                page=new Page(totalCount,pageNow);
                contestList=contestMapper.selectByTitle(title,page.getStartPos(),page.getPageSize());
            }else {
                page=new Page(totalCount,1);
                contestList=contestMapper.selectByTitle(title,page.getStartPos(),page.getPageSize());
            }
            res.setData(contestList);
            res.setMsg(String.valueOf(page.getTotalPageCount()));

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d

}
