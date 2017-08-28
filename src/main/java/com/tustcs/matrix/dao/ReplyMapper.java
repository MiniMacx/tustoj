package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer rid);

    List<Reply> selectByTopicId(Integer topicId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKeyWithBLOBs(Reply record);

    int updateByPrimaryKey(Reply record);

    List<Reply> selectReplyByTopicId(@Param("topicId")Integer topicId,@Param("startPos")int offset,
                                            @Param("pageSize") int pageSize);

    int selectReplyCount(Integer topicId);

    Reply selectReplyByParentId(Integer parentId);

    int updateVoteUp(Integer replyId);

    int updateVoteDown(Integer replyId);
}