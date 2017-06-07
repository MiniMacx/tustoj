package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    List<News> selectNewsList(@Param("offset")int offset,@Param("limit") int limit);

    List<News> selectByTitle(@Param("title")String title);
}