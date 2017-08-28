package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Solution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by polykickshaw on 17-6-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")

public class SolutionMapperTest {
    @Resource
    SolutionMapper solutionMapper;

    @Test
    public void insertSelective() throws Exception {
        Solution solution=new Solution();
        solution.setIp("123.3.3.1");
        solution.setUserId("15103109");
        solution.setInDate(new Date());
        solution.setLanguage(1);
        solution.setCodeLength(111);
        solutionMapper.insertSelective(solution);
    }



    @Test
    public void selectAcceptedSolutionByPage() throws Exception {
        solutionMapper.selectAcceptedSolutionByPage(0,10,"14101118",(short)13);
    }

}