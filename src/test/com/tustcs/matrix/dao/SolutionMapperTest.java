package com.tustcs.matrix.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

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
    public void selectAcceptedSolutionByPage() throws Exception {
        solutionMapper.selectAcceptedSolutionByPage(0,10,"14101118",(short)13);
    }

}