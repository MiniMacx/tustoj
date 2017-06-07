package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);

    List<Topic> selectTopicList(@Param("offset") int offset,@Param("limit") int limit);

    List<Topic> selectByTitle(@Param("title") String title);



}