package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.User;
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
     * [学生级别以上可使用]
     * 分页获取用户名单
     * @param offset
     * @param limit
     * @return
     */
<<<<<<< HEAD
    List<User> selectUserList(@Param("offset") int offset, @Param("limit") int limit);
=======
    List<User> selectUserList(@Param("offset") int offset ,@Param("limit") int limit );
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d

    /**
     * [管理员使用]
     * 根据用户等级返回用户名单
     * @param level
     * @return
     */
    List<User> selectUsingLevel(@Param("level") int level);

    /**
     * [学生级别以上可使用]
     * 根据用户id模糊查找
     * @param userId
     * @return
     */
    List<User> selectUsingId(@Param("userId") String userId);


    List<User> selectAllUser();



}