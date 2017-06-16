package com.tustcs.matrix.oj.service;

import com.tustcs.matrix.oj.entity.User;

import java.util.List;

/**
 * Created by polykickshaw on 17-6-3.
 */

public interface AdminService {

    /**
     * 用户部分
     * @param userId
     * @return
     */
    List<User> getUser(String userId);

    List<User> getUser(int level);

    List<User> getUserList(int offset,int limit);

    int deleteUser(String userId);

    int updateUser(User user);



}
