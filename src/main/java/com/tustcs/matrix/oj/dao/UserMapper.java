package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    /**
     * 获取用户名单
     * @param offset
     * @param limit
     * @return
     */
    List<User> selectUserList(@Param("offset") int offset ,@Param("limit") int limit );

    /**
     * 根据用户等级返回用户名单
     * @param level
     * @return
     */
    List<User> selectByLevel(@Param("level") int level);

    /**
     * 根据用户id模糊查找
     * @param userId
     * @return
     */
    List<User> selectById(@Param("userId") String userId);

}