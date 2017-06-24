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

    /**
     * 分页获取新闻信息
     * @param startPos
     * @param pageSize
     * @return
     */
    List<News> selectNewsList(@Param("startPos") int startPos, @Param("pageSize") int pageSize);

    /**
     * 获取新闻总数
     * @return
     */
    Integer selectNewsCount();


    /**
     * 分页根据标题返回新闻
     * @param title
     * @param startPos
     * @param pageSize
     * @return
     */
    List<News> selectByTitle(@Param("title") String title, @Param("startPos") int startPos, @Param("pageSize") int pageSize);

    /**
     * 根据标题获取新闻总数
     * @param title
     * @return
     */
    Integer selectNewsCountUsingTitle(@Param("title") String title);
}