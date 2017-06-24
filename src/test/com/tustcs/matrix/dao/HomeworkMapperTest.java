package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Homework;
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
public class HomeworkMapperTest {
    @Resource
    private HomeworkMapper homeworkMapper;


    @Test
    public void insert() throws Exception {
        Homework homework=new Homework("linlinlin","19970815","19980815",99.9,
                                    0,"1001 1002 1003");

        homeworkMapper.insert(homework);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        homeworkMapper.selectByPrimaryKey(1002);
    }

    @Test
    public void selectHomeworkList() throws Exception {
        homeworkMapper.selectHomeworkList(0,10);
    }

}