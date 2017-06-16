package com.tustcs.matrix.service;

<<<<<<< HEAD
import com.tustcs.matrix.entity.Homework;
import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.entity.Course;
=======
import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.entity.Course;
import com.tustcs.matrix.entity.Homework;
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d

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
