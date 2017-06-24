package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Reply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by polykickshaw on 17-6-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ReplyMapperTest {
    @Resource
    private ReplyMapper replyMapper;

    @Test
    public void selectReplyByVotes() throws Exception {
        List<Reply> replyList= replyMapper.selectReplyByVotes(0,10,1001);
        for (Reply reply :
             replyList) {
            System.out.println(reply.getRid());
        }
    }

}