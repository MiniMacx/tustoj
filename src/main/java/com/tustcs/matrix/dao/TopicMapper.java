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

    List<Topic> selectByProblemId(@Param("problemId")Integer problemId,@Param("startPos")int startPos,
                                  @Param("pageSize")int pageSize);

    Integer selectTopicCountUsingProblemId(@Param("problemId") Integer problemId);

    List<Topic> selectByContestId(@Param("contestId")Integer contestId,@Param("startPos")int startPos,
                                  @Param("pageSize")int pageSize);

    Integer selectTopicCountUsingContestId(@Param("contestId")Integer contestId);

    Integer addCount(@Param("topicId")Integer topicId);
}