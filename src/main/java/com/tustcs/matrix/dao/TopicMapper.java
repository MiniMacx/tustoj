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

<<<<<<< HEAD
    /**
     * 返回讨论标题
     * @param startPos
     * @param pageSize
     * @return
     */
    List<Topic> selectTopicList(@Param("startPos") int startPos, @Param("pageSize") int pageSize);

    /**
     * 返回讨论标题数量
     * @return
     */
    Integer selectCount();

    /**
     * 根据标题查找
     * 返回讨论标题
     * @param title
     * @param startPos
     * @param pageSize
     * @return
     */
    List<Topic> selectByTitle(@Param("title") String title,@Param("startPos") int startPos,
                              @Param("pageSize") int pageSize);

    /**
     * 根据标题
     * 返回讨论数量
     * @param title
     * @return
     */
    Integer selectTopicCountUsingTitle(@Param("title")String title);

    /**
     * 根据用户id查找
     * 返回讨论标题
     * @param userId
     * @param startPos
     * @param pageSize
     * @return
     */
    List<Topic> selectByUserId(@Param("userId")String userId,@Param("startPos")int startPos,
                               @Param("pageSize")int pageSize);

    /**
     * 根据用户id
     * 返回讨论标题
     * @param userId
     * @return
     */
    Integer selectTopicCountUsingUserId(@Param("userId")String userId);
=======
    List<Topic> selectTopicList(@Param("offset") int offset,@Param("limit") int limit);

    List<Topic> selectByTitle(@Param("title") String title);



>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
}