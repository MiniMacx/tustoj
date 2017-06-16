package com.tustcs.matrix.service.impl;

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
    public List<Reply> showReply(Integer pageNow) {
        List<Reply> replyList;

        if(pageNow!=null){
            replyList=replyMapper.selectReplyList((pageNow - 1) * Page.pageSize,Page.pageSize);
        }else {
            return null;
        }

        return replyList;

    }
}
