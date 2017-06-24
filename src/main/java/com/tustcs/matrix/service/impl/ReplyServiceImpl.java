package com.tustcs.matrix.service.impl;

import com.sun.org.apache.regexp.internal.RE;
import com.tustcs.matrix.dao.ReplyMapper;
import com.tustcs.matrix.entity.Reply;
import com.tustcs.matrix.service.ReplyService;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-12.
 */
@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {
    @Resource
    ReplyMapper replyMapper;

    @Override
    public List<Reply> showReply(Integer pageNow,Integer topicId) {
        List<Reply> replyList;

        if(pageNow!=null){
            replyList=replyMapper.selectReplyList((pageNow - 1) * Page.pageSize,Page.pageSize,
                                                    topicId);
        }else {
            return null;
        }

        return replyList;

    }

    @Override
    public List<Reply> showReplyByVotes(Integer pageNow,Integer topicId) {
        return null;
    }

    @Override
    public boolean addReply(Reply reply) {
        return replyMapper.insert(reply)>0;
    }

    @Override
    public boolean updateReply(Reply reply) {
        return replyMapper.updateByPrimaryKeySelective(reply)>0;
    }

    @Override
    public boolean deleteReply(Integer replyId) {
        Reply reply=new Reply();
        reply.setRid(replyId);
        reply.setDeleteFlag(1);
        return replyMapper.updateByPrimaryKeySelective(reply)>0;
    }
}
