package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Reply;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;

import java.util.List;
=======
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKeyWithBLOBs(Reply record);

    int updateByPrimaryKey(Reply record);
<<<<<<< HEAD

    List<Reply> selectReplyList(@Param("startPos") int startPos,@Param("pageSize") int pageSize);

    Integer selectReplyCount();

=======
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
}