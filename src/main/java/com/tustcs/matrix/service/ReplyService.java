package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Reply;

import java.util.List;

/**
 * Created by polykickshaw on 17-6-12.
 */
public interface ReplyService {
    List<Reply> showReply(Integer pageNow);
}
