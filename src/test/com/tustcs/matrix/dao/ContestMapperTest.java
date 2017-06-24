package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by polykickshaw on 17-6-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ContestMapperTest {


    @Resource
    private ContestMapper contestMapper;

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Contest contest=new Contest();
        contest.setDeleteFlag(1);
        contest.setContestId(1004);
        contestMapper.updateByPrimaryKeySelective(contest);
    }

    @Test
    public void selectContestList() throws Exception {
        contestMapper.selectByPrimaryKey(1002);
    }

    @Test
    public void selectContestCount() throws Exception {
    }

    @Test
    public void selectByTitle() throws Exception {
    }

    @Test
    public void selectContestCountUsingTitle() throws Exception {
    }


    @Test
    public void insert() throws Exception {

        Contest contest = new Contest();
        contest.setStartTime(DateUtils.StringtoDate("1235489113548"));
        contest.setEndTime(DateUtils.StringtoDate("15489511515545"));
        contest.setTitle("title");
        contest.setDefunct("N");
        contest.setDeleteFlag(0);
        contest.setDescription("description");
        contest.setLangmask(0);
        contest.setPrivateFlag((byte) 0);
        contest.setPassword("123");
        contestMapper.insert(contest);
    }

}