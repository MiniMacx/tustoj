package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.Reply;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKeyWithBLOBs(Reply record);

    int updateByPrimaryKey(Reply record);
}