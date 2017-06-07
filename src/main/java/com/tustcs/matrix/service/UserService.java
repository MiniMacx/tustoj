package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.entity.Course;
import com.tustcs.matrix.entity.Homework;

import java.util.List;

/**
 * Created by polykickshaw on 17-6-3.
 */
public interface UserService {


    boolean loginService(String userId,String userPwd);

    int queryOwnSubmit(String userId);

    List queryAllSubmit();

    List<Course> queryCourseList(String userId);

    List<Homework> queryHomeWorkList(String userId);

    List<Contest> queryContestList(String UserId);

}
