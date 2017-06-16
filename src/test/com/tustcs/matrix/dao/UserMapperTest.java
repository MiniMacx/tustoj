package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by polykickshaw on 17-5-31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserMapperTest {


    @Autowired
    UserMapper userMapper;


    @Test
    public void selectUserList() throws Exception {
        userMapper.selectUserList(0,2);
    }

    @Test
    public void selectByLevel() throws Exception {
        //userMapper.selectByLevel(4);
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        User u=new User();
        u.setAccesstime(new Date());
        u.setUserId("15103109");
        u.setDefunct("N");
        u.setIp("127.0.0.1");
        u.setLevel(4);
        u.setVolume(1);
        u.setLanguage(1);
        u.setNick("lol");
        u.setSchool("tianjinkeji");
        userMapper.insert(u);

    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}