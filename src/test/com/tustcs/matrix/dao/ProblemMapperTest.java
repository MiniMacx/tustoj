package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.ProblemWithBLOBs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by polykickshaw on 17-6-5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ProblemMapperTest {
    @Resource
    ProblemMapper problemMapper;

    @Test
    public void selectProblemList() throws Exception {
        List<ProblemWithBLOBs> problemWithBLOBsList= problemMapper.selectProblemList(0,10);
        for (ProblemWithBLOBs p:
             problemWithBLOBsList) {
            System.out.println(p.getTitle());
        }

    }

    @Test
    public void selectByTitle() throws Exception {

    }

}